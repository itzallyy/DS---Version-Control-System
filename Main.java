import java.util.Stack;

class Version {
    String content;
    Version next; 
    Version prev;

    Version(String content){
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

class VersionControl {
    Version head;
    Version current;
    Stack<String> undoSt = new Stack<>();
    Stack<String> redoSt = new Stack<>();
    
    void save(String content){

        Version newVer = new Version(content);

        if(head==null){
            head = newVer;
            current = head;
        } else {
            current.next = newVer;
            newVer.prev = current;
            current = newVer;
        }

        redoSt.clear();
    }

    void undo(){
        if(current != null && current.prev !=null){
            current = current.prev;
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    void redo(){
        if(current != null && current.next != null){
            current = current.next;
        } else {
            System.out.println("Nothing to redo");
        }
    }

    void showCurr(){
        if(current==null){
            System.out.println("No versions are available");
        } else{ 
        System.out.println("Current Version: " + current.content);
        }
    }

    void showAll(){
        Version temp = head;
        int i =1;
        while(temp!=null){
            System.out.println("Version " + i + ": " + temp.content);
            temp = temp.next;
            i++;        
        }
    }
}

public class Main{
    public static void main(String[] args){
        VersionControl vc = new VersionControl();

        vc.save("Test 1");
        vc.save("Test 2");
        vc.save("Test 3");

        System.out.println("\nShowing all versions ");
        vc.showAll();

        System.out.println("\nShowing current version ");
        vc.showCurr();

        System.out.println("\nUndo");
        vc.undo();
        
        System.out.println("\nShowing current version after undo operation");
        vc.showCurr();
        
        System.out.println("\nShowing all versions ");
        vc.showAll();

        System.out.println("\nUndo");
        vc.undo();

        System.out.println("\nShowing current version after undo operation");
        vc.showCurr();
        
        System.out.println("\nShowing all versions ");
        vc.showAll();

        System.out.println("\nRedo");
        vc.redo();

        System.out.println("\nShowing current version after redo operation");
        vc.showCurr();
        
        System.out.println("\nShowing all versions ");
        vc.showAll();
       
    }
}

//to compile the code - " javac Main.java "
//when done compiling, run using " java Main "