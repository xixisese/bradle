class TaskContainer{
   void register(String name, Closure cl){
        println name + ":tasks.register get called"
   }

   void run(String taskName){
       println "Get to run task:" + taskName
   }
}

abstract class Project extends Script{
    TaskContainer tasks

    Project(){
        tasks = new TaskContainer()
    }

    void repositories(Closure cl){
        println "repositories get called"
    }
    void dependencies(Closure cl){
        println "dependencies get called"
    }
}
