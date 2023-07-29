package controller;

import model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    public void save(Person person) throws IOException{
        File file = new File(person.getFirstname()+".txt");
        try(FileWriter writer = new FileWriter(file, true)){
            StringBuilder sb = new StringBuilder();
            sb.append("<").append(person.getFirstname()).append(">");
            sb.append("<").append(person.getName()).append(">");
            sb.append("<").append(person.getLastname()).append(">");
            sb.append("<").append(person.getBirthday()).append(">");
            sb.append("<").append(person.getPhoneNumber()).append(">");
            sb.append("<").append(person.getGender()).append(">\n");
            writer.write(sb.toString());
        } catch (IOException e){
            throw new IOException("Ошибка записи в файл");
        }
    }

    public List<String> readPeople(String firstname) throws IOException{
        File file = new File(firstname+".txt");
        List<String> people = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while (reader.ready()){
                people.add(reader.readLine());
            }
        } catch (FileNotFoundException e){
            throw new IOException("Ошибка открытия файла с именем "+firstname, e);
        } catch (IOException e){
            throw new IOException("Ошибка чтения из файла");
        }
        return people;
    }
}
