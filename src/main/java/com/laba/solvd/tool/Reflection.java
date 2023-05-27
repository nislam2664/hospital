package com.laba.solvd.tool;

import com.laba.solvd.enums.Gender;
import com.laba.solvd.hospital.patient.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Reflection {
    private static final Logger logger = LogManager.getLogger(Reflection.class.getName());

    public static void reflection() {
        try {
            Patient myPatient = new Patient("Eric Adams", LocalDate.parse("1995-07-04"), Gender.MALE);

            Class patient = myPatient.getClass();
            logger.info("Patient class name was obtained");
            System.out.println("[ CLASS NAME ] == " + patient.getName() + " -> " + Modifier.toString(patient.getModifiers()));
            logger.info("Patient class interfaces were obtained");
            List<Class> patientInterfaces = Arrays.asList(patient.getInterfaces());

            System.out.println("[ INTERFACES ]");
            patientInterfaces.stream().forEach(classItem -> System.out.println("\t" + classItem.getName() + " -> " + Modifier.toString(classItem.getModifiers())));

            logger.info("Patient class fields were obtained");
            List<Field> patientFields = Arrays.asList(myPatient.getClass().getDeclaredFields());
            logger.info("Patient class methods were obtained");
            List<Method> patientMethods = Arrays.asList(myPatient.getClass().getDeclaredMethods());

            System.out.println("[ FIELDS ]");
            patientFields.stream().forEach(field -> System.out.println("\t" + field.getName() + " -> " + Modifier.toString(field.getModifiers())));

            System.out.println("[ METHODS ]");
            patientMethods.stream().forEach(method -> System.out.println("\t" + method.getName() + " -> " + Modifier.toString(method.getModifiers())));
            System.out.println();
        } catch (Exception e) {
            logger.error("Error has occurred!!!");
            e.printStackTrace();
        }
    }
}
