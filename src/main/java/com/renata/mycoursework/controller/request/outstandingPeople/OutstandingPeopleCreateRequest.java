package com.renata.mycoursework.controller.request.outstandingPeople;
import com.renata.mycoursework.entity.enums.Gender;
import lombok.Data;
@Data
public class OutstandingPeopleCreateRequest {
    private String name;
    private String surname;
    private String patronymic;
    private Gender gender = Gender.NOT_SELECTED;
    private int yearOfBirth;
    private int yearOfDeath;
    private String photoUrl;
    private String biography;

    // зависимости
    private String academicTitles;
    private String academicDegrees;
    private String scientificFields;
}
