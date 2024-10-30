package be;

public class ValidationObj
{
    private String Name;
    private int Age;

    public ValidationObj(String name, int age)
    {
        this.Name = name;
        this.Age = age;
    }

    public String getName()
    {
        return this.Name;
    }

    public int getAge()
    {
        return this.Age;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public void setAge(int age)
    {
        this.Age = age;
    }
}
