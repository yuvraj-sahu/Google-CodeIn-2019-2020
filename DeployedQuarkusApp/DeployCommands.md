# Deploy Commands

We will be deploying to two platforms: Kubernetes and OpenShift. For both of these platforms, we must create a Docker container. These are the commands to do these tasks in Windows.

## Creating a Docker container

You can pull my Docker container from this link: https://hub.docker.com/r/ysahu/sample-app.

Once you have created a Docker account and downloaded Docker desktop, you are ready to start! Navigate to the app directory (named <b>sample-app</b> for this example) using the <b>cd</b> command. Then, execute the following:

<b>mvnw package</b>

<i>Before executing the next command, create a new Docker repository for your container through DockerHub. </i>

The Dockerfile has been created, so you can now build the docker container:

<b>docker build -f src/main/docker/Dockerfile.jvm -t \<username>/<repository_name> . </b>

Where you fill \<username> and <repository_name> as they apply to you. Don't forget the dot at the end! Then, you can test out your container by running your Docker container:

<b>docker run -i --rm -p 8080:8080 \<username>/<repository_name></b>

And you should be able to launch localhost:8080 and see your Quarkus app.

Now, you must push your container to your Docker repository:

<b>docker push \<username>/<repository_name> </b>

You have now pushed your Docker container to your repistory! You are ready to move on to deploying to Kubernetes.

## Deploying to Kubernetes

Make sure that you have Hyper-V, minikube, and kubectl installed before you start.

To start a new cluster, run:

<b> minikube start -p <cluster_name> --vm-driver=hyperv </b>

Make sure that you run this command as an administrator. Certain commands (including enabling Hyper-V) require elevation.

Then, you must run:

<b>kubectl run <name> --image=\<username>/<repository_name>:latest --port=8080 --image-pull-policy=IfNotPresent </b>

You can choose the <name>. Once you have run this, you must execute:

<b>kubectl expose deployment <name> --type=NodePort </b>
