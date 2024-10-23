package bll;

public class ValidationLogic
{
    private int AgeLimit = 15;

    public boolean validate(int age)
    {
        if(age < AgeLimit || age < 0)
        {
            return false;
        }
        return true;
    }
}
