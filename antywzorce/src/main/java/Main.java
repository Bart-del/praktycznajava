import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main
{
    public static void main(String[] args) {

    }

    /*
    private boolean isHappy(boolean expression1, boolean expression2) {
        if(expression1) {
            return expression2;
        }
        else
        {
            return false;
        }
    }

     */

    private boolean isHappy(boolean expression1, boolean expression2) {
        return expression1 && expression2;
    }

    public void choseCommand(int command)
    {
        if (command == 1)
        {
            command1();
        }

        if (command == 2)
        {
            command2();
        }

        if (command == 3)
        {
            command3();
        }
    }

    public void command1()
    {

    }

    public void command2()
    {

    }

    public void command3()
    {

    }

    void initProcess(String id,
                     String name,
                     int heapValue,
                     boolean isThreadBLocker,
                     boolean backgroundProcess,
                     LocalDateTime localDateTimeOfExecution,
                     Object... dataToProcess
                     )
    {
       //....
    }

    void initProcess(Process process)
    {
        //...
    }

}
