package tasks;

public class StringLength implements Task{
    @Override
    public String execute(String str) {
        return String.valueOf(str.length());
    }
}
