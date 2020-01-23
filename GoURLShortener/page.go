package main

import (
    "log"
    "net/http"
    "fmt"
)

var redirectionMap map[string]string

func handler(w http.ResponseWriter, r *http.Request) {
    path := r.URL.Path
    redirectionURL := redirectionMap[path]
    if redirectionURL == "" {
        fmt.Fprintf(w, "Hello! Go to localhost:8080/go to be redirected to golang.org, or go to localhost:8080/google to be redirected to google.com. ")
    } else {
        http.Redirect(w, r, redirectionURL, http.StatusFound)
    }
}

func main() {

    redirectionMap = make(map[string]string)
    redirectionMap["/go"] = "http://golang.org"
    redirectionMap["/google"] = "http://google.com"

    http.HandleFunc("/", handler)
    log.Fatal(http.ListenAndServe(":8080", nil))
}