NOTE: by now these files are WIP, because we need to merge a fix:

    multiplication-wf.sw.json.withEvents.notWorking.until.merge.is.fixed
    event-display.yaml
    knative-resouces.yaml


1) eval $(minikube -p knative docker-env)

2) kubectl create namespace test1

3) cd multiplication-service

4) mvn clean install

5) kubectl apply -f target/kubernetes/kubernetes.yml -n test1

6) cd to the multiplication-workflow

7) kn deploy --namespace test1

8) minikube service list -p knative

| test1                      | multiplication-service                                 | http/80      | http://192.168.58.2:31286 |
| test1                      | multiplication-wf                                      |           80 | http://192.168.58.2:30098 |

9) using hte url for the multiplication-wf you can create a WF instance with

curl -X POST -H 'Content-Type:application/json' -H 'Accept:application/json' -d '{ "a" : 2, "b" : 3}'  http://192.168.58.2:30098/multiplication-wf

you'll see an output like this:

{"id":"8cf89493-baaa-469d-b1e0-f7b054af51cc","workflowdata":{"a":2,"b":3,"product":6.0}}


