package groovydls
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

abstract class Project extends Script{
    TaskContainer tasks

    Project(){
        tasks = new TaskContainer()
    }

    void repositories(Closure cl){
       RepositoriesDelegate repDlg = new RepositoriesDelegate()
       cl.delegate = repDlg
       cl.resolveStrategy = Closure.DELEGATE_ONLY
       cl.call()
    }

    void dependencies(Closure cl){
       DependenciesDelegate depDlg = new DependenciesDelegate()
       cl.delegate = depDlg
       cl.resolveStrategy = Closure.DELEGATE_ONLY
       cl.call()
    }
}

class TaskContainer{
   static final ConcurrentMap<String, Closure> taskMap = [:] as ConcurrentHashMap
   void register(String name, Closure cl){
        taskMap."$name" = cl
   }

   void run(String name){
        Closure cl = taskMap."$name"
        TaskDelegate tDlg = new TaskDelegate()
        cl.delegate = tDlg
        cl.resolveStrategy = Closure.DELEGATE_ONLY
        cl.call()
   }
}


class RepositoriesDelegate{
    void mavenCentral(){
        println "mavenCentral get called"
    }
}

class DependenciesDelegate{
    void implementation(String id){
        println "implementation get called, id:"+id
    }

    void testImplementation(String id){
        println "testImplementation get called, id:"+id
    }
}

class TaskDelegate{
    void doLast(Closure cl){
        cl.call()
    }
}
