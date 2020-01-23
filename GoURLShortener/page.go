package main

import (
    "log"
    "net/http"
    "fmt"
)

func handler(w http.ResponseWriter, r *http.Request) {
    path := r.URL.Path
    if path == "/go" {
        http.Redirect(w, r, "http://golang.org", http.StatusFound)
    } else {
        fmt.Fprintf(w, "Hello! Go to localhost:8080/go to be redirected to golang.org. ")
    }
}

func main() {
    http.HandleFunc("/", handler)
    log.Fatal(http.ListenAndServe(":8080", nil))
}