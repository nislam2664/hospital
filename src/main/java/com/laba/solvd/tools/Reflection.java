package com.laba.solvd.tools;

import com.laba.solvd.enums.Gender;
import com.laba.solvd.hospital.patient.Patient;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Reflection {
    public static void reflection() {
        try {

            Patient myPatient = new Patient("Eric Adams", LocalDate.parse("1995-07-04"), Gender.MALE);

            Class patient = myPatient.getClass();
            System.out.println("[ CLASS NAME ] == " + patient.getName() + " -> " + Modifier.toString(patient.getModifiers()));
            List<Class> patientInterfaces = Arrays.asList(patient.getInterfaces());

            System.out.println("[ INTERFACES ]");
            patientInterfaces.stream().forEach(classItem -> System.out.println("\t" + classItem.getName() + " -> " + Modifier.toString(classItem.getModifiers())));

            List<Field> patientFields = Arrays.asList(myPatient.getClass().getDeclaredFields());
            List<Method> patientMethods = Arrays.asList(myPatient.getClass().getDeclaredMethods());

            System.out.println("[ FIELDS ]");
            patientFields.stream().forEach(field -> System.out.println("\t" + field.getName() + " -> " + Modifier.toString(field.getModifiers())));

            System.out.println("[ METHODS ]");
            patientMethods.stream().forEach(method -> System.out.println("\t" + method.getName() + " -> " + Modifier.toString(method.getModifiers())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
