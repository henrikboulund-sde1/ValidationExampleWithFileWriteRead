package bll;

import be.ValidationObj;
import dal.FileDataAccess;

import java.util.List;

public class FileDataLogic
{
    FileDataAccess fileAccess = new FileDataAccess();

    public List<ValidationObj> loadData()
    {
        List<ValidationObj> result = fileAccess.loadData();
        List<ValidationObj> reversedList = result.reversed();
        return reversedList;
    }

    public boolean writeToFile(ValidationObj obj)
    {
        return fileAccess.writeToFile(obj);
    }
}
