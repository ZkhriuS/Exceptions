package view;

import controller.FileController;
import controller.ValidationController;
import exceptions.MenuException;
import exceptions.ValidationException;
import model.Person;

import java.io.*;
import java.util.List;

public class ConsoleView {
    private ValidationController vController;
    private FileController fController;

    public ConsoleView(ValidationController vController, FileController fController){
        this.vController = vController;
        this.fController = fController;
    }
    public void view(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    switch (menu(reader)) {
                        case ADD: add(reader); break;
                        case SHOW: show(reader); break;
                        case EXIT: return;
                    }
                } catch (NumberFormatException e){
                    System.out.println("Ошибка приведения типа");
                    e.printStackTrace();
                } catch (ValidationException | MenuException | IOException e){
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (IOException e){
            System.out.println("Ошибка в потоке ввода");
            e.printStackTrace();
        }
    }

    private Menu menu(BufferedReader reader) throws MenuException, IOException, NumberFormatException {
        System.out.println("1. Добавить пользователя");
        System.out.println("2. Посмотреть пользователей по фамилии");
        System.out.println("3. Выйти");
        int action = Integer.parseInt(reader.readLine());
        if(action>Menu.values().length || action<1)
            throw new MenuException("Введен несуществующий пункт меню: "+action);
        return Menu.values()[action-1];
    }

    private void add(BufferedReader reader) throws ValidationException, IOException{
        System.out.println("Введите пользователя в формате \"Фамилия Имя Отчество дд.мм.гггг +375(00)0000000 f\\m\"");
        String line = reader.readLine();
        Person person = vController.validate(line);
        fController.save(person);
    }
    private void show(BufferedReader reader) throws ValidationException, IOException{
        System.out.print("Введите фамилию: ");
        String firstname = reader.readLine();
        vController.validateName(firstname);
        List<String> people = fController.readPeople(firstname);
        for (String person:people) {
            System.out.println(person);
        }
    }
}
