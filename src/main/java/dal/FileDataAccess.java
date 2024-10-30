package dal;

import be.ValidationObj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDataAccess
{
    private File MemoryFile = new File("/Users/henrikboulund/ValidationFile.txt");

    public List<ValidationObj> loadData()
    {
        List<ValidationObj> result = new ArrayList<>();
        try
        {
            Scanner fileReader = new Scanner(MemoryFile);
            while(fileReader.hasNextLine())
            {
                String[] outputStr = fileReader.nextLine().split(",");
                result.add(new ValidationObj(outputStr[0], Integer.parseInt(outputStr[1].trim())));
            }
            fileReader.close();
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        return result;
    }

    public boolean writeToFile(ValidationObj obj)
    {
        try
        {
            FileWriter fw = new FileWriter(MemoryFile.getPath(), true);
            fw.write("\n");
            fw.write(obj.getName() + ", " + obj.getAge());
            fw.close();
            return true;
        }
        catch(IOException e)
        {
            return false;
        }
    }
}
