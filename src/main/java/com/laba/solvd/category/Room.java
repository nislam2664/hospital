package com.laba.solvd.category;

import com.laba.solvd.exception.NegativeNumberException;
import com.laba.solvd.interfaces.Information;
import com.laba.solvd.tool.StringManipulation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public abstract class Room implements Information {
    private static final Logger logger = LogManager.getLogger(Room.class.getName());

    private int floorNumber;
    private int roomNumber;
    private int maxCapacity;

    public Room() {

    }

    public Room(int floorNumber, int roomNumber, int maxCapacity) {
        setFloorNumber(floorNumber);
        setRoomNumber(roomNumber);
        setMaxCapacity(maxCapacity);
    }

    public final int getFloorNumber() {
        return floorNumber;
    }

    public final int getRoomNumber() {
        return roomNumber;
    }

    public final int getMaxCapacity() {
        return maxCapacity;
    }

    public final void setFloorNumber(int floorNumber) {
        Scanner scanner = new Scanner(System.in);
        try {
            if (floorNumber <= 0)
                throw new NegativeNumberException();
            this.floorNumber = floorNumber;
            logger.info("Floor number was established");
        }
        catch (NegativeNumberException e) {
            logger.warn("Negative floor number was set");
            System.out.print("Floor number cannot be negative.\nProvide a valid floor number : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Integer.parseInt(num) <= 0)
                        throw new NegativeNumberException();
                    this.floorNumber = Integer.parseInt(num);
                    logger.info("Floor number was established");
                    break;
                } catch (NegativeNumberException ex) {
                    logger.warn("Negative floor number was set");
                    System.out.print("Floor number cannot be negative.\nProvide a valid floor number : ");
                } catch (InputMismatchException ex) {
                    logger.warn("Floor number invalid");
                    System.out.print("Floor number given was not a valid number input.\nProvide a valid floor number : ");
                }
            }
        } catch (InputMismatchException e) {
            logger.warn("Floor number invalid");
            System.out.print("Floor number given was not a valid number input.\nProvide a valid floor number : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Integer.parseInt(num) <= 0)
                        throw new NegativeNumberException();
                    this.floorNumber = Integer.parseInt(num);
                    logger.info("Floor number was established");
                    break;
                } catch (NegativeNumberException ex) {
                    logger.warn("Negative floor number was set");
                    System.out.print("Floor number cannot be negative.\nProvide a valid floor number : ");
                } catch (InputMismatchException ex) {
                    logger.warn("Floor number invalid");
                    System.out.print("Floor number given was not a valid number input.\nProvide a valid floor number : ");
                }
            }
        }
    }

    public final void setRoomNumber(int roomNumber) {
        Scanner scanner = new Scanner(System.in);
        try {
            if (roomNumber <= 0)
                throw new NegativeNumberException();
            this.roomNumber = roomNumber;
            logger.info("Room number was established");
        }
        catch (NegativeNumberException e) {
            logger.warn("Negative room number was set");
            System.out.print("Room number cannot be negative.\nProvide a valid room number : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Integer.parseInt(num) <= 0)
                        throw new NegativeNumberException();
                    this.roomNumber = Integer.parseInt(num);
                    logger.info("Room number was established");
                    break;
                } catch (NegativeNumberException ex) {
                    logger.warn("Negative room number was set");
                    System.out.print("Room number cannot be negative.\nProvide a valid room number : ");
                } catch (InputMismatchException ex) {
                    logger.warn("Room number invalid");
                    System.out.print("Room number given was not a valid number input.\nProvide a valid room number : ");
                }
            }
        } catch (InputMismatchException e) {
            logger.warn("Room number invalid");
            System.out.print("Room number given was not a valid number input.\nProvide a valid room number : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Integer.parseInt(num) <= 0)
                        throw new NegativeNumberException();
                    this.roomNumber = Integer.parseInt(num);
                    logger.info("Room number was established");
                    break;
                } catch (NegativeNumberException ex) {
                    logger.warn("Negative room number was set");
                    System.out.print("Room number cannot be negative.\nProvide a valid room number : ");
                } catch (InputMismatchException ex) {
                    logger.warn("Room number invalid");
                    System.out.print("Room number given was not a valid number input.\nProvide a valid room number : ");
                }
            }
        }
    }

    public final void setMaxCapacity(int maxCapacity) {
        Scanner scanner = new Scanner(System.in);
        try {
            if (maxCapacity <= 0)
                throw new NegativeNumberException();
            this.maxCapacity = maxCapacity;
            logger.info("Max capacity was established");
        }
        catch (NegativeNumberException e) {
            logger.warn("Negative max capacity was set");
            System.out.print("Max capacity cannot be negative.\nProvide a valid number : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Integer.parseInt(num) <= 0)
                        throw new NegativeNumberException();
                    this.maxCapacity = Integer.parseInt(num);
                    logger.info("Max capacity was established");
                    break;
                } catch (NegativeNumberException ex) {
                    logger.warn("Negative max capacity was set");
                    System.out.print("Max capacity cannot be negative.\nProvide a valid number : ");
                } catch (InputMismatchException ex) {
                    logger.warn("Max capacity invalid");
                    System.out.print("Max capacity given was not a valid number input.\nProvide a valid number : ");
                }
            }
        } catch (InputMismatchException e) {
            logger.warn("Max capacity invalid");
            System.out.print("Max capacity given was not a valid number input.\nProvide a valid number : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Integer.parseInt(num) <= 0)
                        throw new NegativeNumberException();
                    this.maxCapacity = Integer.parseInt(num);
                    logger.info("Max capacity was established");
                    break;
                } catch (NegativeNumberException ex) {
                    logger.warn("Negative max capacity was set");
                    System.out.print("Max capacity cannot be negative.\nProvide a valid number : ");
                } catch (InputMismatchException ex) {
                    logger.warn("Max capacity invalid");
                    System.out.print("Max capacity given was not a valid number input.\nProvide a valid number : ");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "floorNumber=" + floorNumber +
                ", roomNumber=" + roomNumber +
                ", maxCapacity=" + maxCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return floorNumber == room.floorNumber && roomNumber == room.roomNumber && maxCapacity == room.maxCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(floorNumber, roomNumber, maxCapacity);
    }
}