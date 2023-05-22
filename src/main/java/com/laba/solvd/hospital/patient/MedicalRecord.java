package com.laba.solvd.hospital.patient;

import com.laba.solvd.enums.*;
import com.laba.solvd.exception.*;
import com.laba.solvd.interfaces.*;
import com.laba.solvd.tools.StringManipulation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public final class MedicalRecord implements Information {
    public static String system = "IMPERIAL";
    private double height;
    private double weight;
    private String bloodPressure;
    private double temperature;
    private final ArrayList<String> diagnosisList =  new ArrayList<>();

    public MedicalRecord() {

    }

    public MedicalRecord(double height, double weight, String bloodPressure, double temperature) {
        this.height = height;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
        setTemperature(temperature);
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public ArrayList<String> getDiagnosis() {
        return diagnosisList;
    }

    public void setHeight(double height) {
        Scanner scanner = new Scanner(System.in);
        try{
            if (height <= 0)
                throw new NegativeNumberException();
            this.height = height;
        }
        catch (NegativeNumberException e) {
            System.out.print("Height cannot be negative.\nPlease enter a valid height : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isNumeric(num))
                        throw new InputMismatchException();
                    if (Double.parseDouble(num) <= 0)
                        throw new NegativeNumberException();
                    this.height = Double.parseDouble(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("Height cannot be negative.\nPlease enter a valid height : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid height.\nPlease enter a valid height : ");
                }
            }
        } catch (InputMismatchException e) {
            System.out.print("Invalid height.\nPlease enter a valid height : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Double.parseDouble(num) <= 0)
                        throw new NegativeNumberException();
                    this.height = Double.parseDouble(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("Height cannot be negative.\nPlease enter a valid height : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid height.\nPlease enter a valid height : ");
                }
            }
        }
    }

    public void setWeight(double weight) {
        Scanner scanner = new Scanner(System.in);
        try{
            if (weight <= 0)
                throw new NegativeNumberException();
            this.weight = weight;
        }
        catch (NegativeNumberException e) {
            System.out.print("Weight cannot be negative.\nPlease enter a valid weight : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isNumeric(num))
                        throw new InputMismatchException();
                    if (Double.parseDouble(num) <= 0)
                        throw new NegativeNumberException();
                    this.weight = Double.parseDouble(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("Weight cannot be negative.\nPlease enter a valid weight : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid weight.\nPlease enter a valid weight : ");
                }
            }
        } catch (InputMismatchException e) {
            System.out.print("Invalid weight.\nPlease enter a valid weight : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Double.parseDouble(num) <= 0)
                        throw new NegativeNumberException();
                    this.weight = Double.parseDouble(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("Weight cannot be negative.\nPlease enter a valid weight : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid weight.\nPlease enter a valid weight : ");
                }
            }
        }
    }

    public void setBloodPressure(String bloodPressure) {
        try {
            if(bloodPressure == null || bloodPressure.isBlank())
                throw new NullDataException();
        } catch (NullDataException e) {
            System.out.println("Blood pressure is unknown. Please input a blood pressure reading.");
        }

        this.bloodPressure = bloodPressure;
    }

    public void setTemperature(double temperature) {
        Scanner scanner = new Scanner(System.in);
        try{
            if (temperature <= 0)
                throw new NegativeNumberException();
            this.temperature = temperature;
        }
        catch (NegativeNumberException e) {
            System.out.print("Temperature is way below normal range.\nEnter a valid temperature : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isNumeric(num))
                        throw new InputMismatchException();
                    if (Double.parseDouble(num) <= 0)
                        throw new NegativeNumberException();
                    this.temperature = Double.parseDouble(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("Temperature is way below normal range.\nEnter a valid temperature : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid temperature.\nPlease enter a valid temperature : ");
                }
            }
        } catch (InputMismatchException e) {
            System.out.print("Invalid temperature.\nPlease enter a valid temperature : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Double.parseDouble(num) <= 0)
                        throw new NegativeNumberException();
                    this.temperature = Double.parseDouble(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("Temperature is way below normal range.\nEnter a valid temperature : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid temperature.\nPlease enter a valid temperature : ");
                }
            }
        }
    }

    public void addDiagnosis(String diagnosis) {
        diagnosisList.add(diagnosis.toLowerCase());
    }

    public static double inchToMeter(double in) {
        return in * 0.0254;
    }

    public static double meterToInch(double m) {
        return m / 0.0254;
    }

    public static double lbToKG(double lb) {
        return lb * 0.453592;
    }

    public static double kgToLB(double kg) {
        return kg / 0.453592;
    }

    public static double fahrenheitToCelsius(double temp) {
        return ((temp-32)*5)/9;
    }

    public static double celsiusToFahrenheit(double temp) {
        return ((temp*9)/5) + 32;
    }

    public void metricToImperial() {
        system = "IMPERIAL";
        height = meterToInch(height);
        weight = kgToLB(weight);
        temperature = celsiusToFahrenheit(temperature);
    }

    public void imperialToMetric() {
        system = "METRIC";
        height = inchToMeter(height);
        weight = lbToKG(weight);
        temperature = fahrenheitToCelsius(temperature);
    }

    @Override
    public void getInfo() {
        System.out.println(">>> Medical Record <<<");
        System.out.println("----------------------");
        System.out.println("Height :: " + height);
        System.out.println("Weight :: " + weight);
        System.out.println("Temperature :: " + temperature);
        System.out.println("Blood Pressure :: " + bloodPressure);
        System.out.println("Diagnosis :: ");
        diagnosisList.stream().forEach((diagnosis) -> System.out.println("\t➢ " + diagnosis));
        System.out.println();
    }

    @Override
    public String toString() {
        return "MedicalRecord{" + "height='" + height + '\'' + ", weight='" + weight + '\'' + ", bloodPressure='" + bloodPressure + '\'' + ", temperature=" + temperature + ", diagnosis='" + diagnosisList + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalRecord that = (MedicalRecord) o;
        return Double.compare(that.temperature, temperature) == 0 && Objects.equals(height, that.height) && Objects.equals(weight, that.weight) && Objects.equals(bloodPressure, that.bloodPressure) && Objects.equals(diagnosisList, that.diagnosisList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, weight, bloodPressure, temperature, diagnosisList);
    }
}
