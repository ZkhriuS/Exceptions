package controller;

import exceptions.*;
import model.Date;
import model.Months;
import model.Person;
import model.PhoneNumber;

public class ValidationController {
    private final static int spaceCount = 6;
    private final static int currentYear = 2023;
    private final static int minYear = 1900;
    public Person validate(String line) throws DataLengthException, ValidationException {
        String[] data = line.split(" ");
        if(data.length>spaceCount) {
            String format = "\"Фамилия Имя Отчество дд.мм.гггг +375(00)0000000 f\\m\"";
            throw new DataLengthException(data.length, format);
        }
        for(int i=0; i<3; i++){
            validateName(data[i]);
        }
        Date date = validateDate(data[3]);
        PhoneNumber phoneNumber = validatePhoneNumber(data[4]);
        String gender = validateGender(data[5]);
        Person person = new Person();
        person.setFirstname(data[0]);
        person.setName(data[1]);
        person.setLastname(data[2]);
        person.setBirthday(date);
        person.setPhoneNumber(phoneNumber);
        person.setGender(gender);
        return person;
    }

    public void validateName(String name) throws NameValidationException {
        String regex = "[A-ZА-Я][a-zа-я]+";
        if(!name.matches(regex))
            throw new NameValidationException("Строка должна содержать только текстовые символы и начинаться с заглавной буквы");
    }

    private Date validateDate(String str) throws DataLengthException, DateValidationException {
        String[] data = str.split("\\.");
        if(data.length!=3)
            throw new DataLengthException(data.length, "дд.мм.гггг");
        if(!str.matches("\\d{2}\\.\\d{2}\\.\\d{4}"))
            throw new DateValidationException("Формат даты должен содержать только числа, разделенные точками");
        int year = Integer.parseInt(data[2]);
        int month = Integer.parseInt(data[1]);
        int day = Integer.parseInt(data[0]);
        if(year > currentYear || year < minYear)
            throw new DateValidationException("Год рождения выходит за допустимый диапазон ["+minYear+", "+currentYear+"]");
        switch (month){
            case 1, 3, 5, 7, 8, 10, 12:
                if(day>31 || day <1)
                    throw new DateValidationException("День рождения выходит за допустимый диапазон [1, 31]");
                break;
            case 4, 6, 9, 11:
                if(day>30 || day <1)
                    throw new DateValidationException("День рождения выходит за допустимый диапазон [1, 30]");
                break;
            case 2:
                if(year%4==0) {
                    if (day > 29 || day < 1)
                        throw new DateValidationException("День рождения выходит за допустимый диапазон [1, 29]");
                }
                else {
                    if (day > 28 || day < 1)
                        throw new DateValidationException("День рождения выходит за допустимый диапазон [1, 28]");
                }
                break;
            default: throw new DateValidationException("Месяц рождения выходит за допустимый диапазон [1, 12]");
        }
        Date date = new Date();
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);
        return date;
    }

    private PhoneNumber validatePhoneNumber(String str){
        String regex = "\\+375\\(\\d{2}\\)\\d{7}";
        if(!str.matches(regex))
            throw new PhoneNumberException("Номер телефона не соответствует формату +375(00)0000000");
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber(str);
        return phoneNumber;
    }

    private String validateGender(String str){
        if(!str.matches("[fm]"))
            throw new GenderValidationException("Пол должен быть введен как f или m");
        return str;
    }


}
