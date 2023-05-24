package com.laba.solvd.category;

import com.laba.solvd.exception.NegativeNumberException;
import com.laba.solvd.interfaces.Information;
import com.laba.solvd.tool.StringManipulation;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public abstract class Room implements Information {
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
        }
        catch (NegativeNumberException e) {
            System.out.print("Floor number cannot be negative.\nProvide a valid floor number : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Integer.parseInt(num) <= 0)
                        throw new NegativeNumberException();
                    this.floorNumber = Integer.parseInt(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("Floor number cannot be negative.\nProvide a valid floor number : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Floor number given was not a valid number input.\nProvide a valid floor number : ");
                }
            }
        } catch (InputMismatchException e) {
            System.out.print("Floor number given was not a valid number input.\nProvide a valid floor number : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Integer.parseInt(num) <= 0)
                        throw new NegativeNumberException();
                    this.floorNumber = Integer.parseInt(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("Floor number cannot be negative.\nProvide a valid floor number : ");
                } catch (InputMismatchException ex) {
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
        }
        catch (NegativeNumberException e) {
            System.out.print("Room number cannot be negative.\nProvide a valid room number : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Integer.parseInt(num) <= 0)
                        throw new NegativeNumberException();
                    this.roomNumber = Integer.parseInt(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("Room number cannot be negative.\nProvide a valid room number : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Room number given was not a valid number input.\nProvide a valid room number : ");
                }
            }
        } catch (InputMismatchException e) {
            System.out.print("Room number given was not a valid number input.\nProvide a valid room number : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Integer.parseInt(num) <= 0)
                        throw new NegativeNumberException();
                    this.roomNumber = Integer.parseInt(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("Room number cannot be negative.\nProvide a valid room number : ");
                } catch (InputMismatchException ex) {
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
        }
        catch (NegativeNumberException e) {
            System.out.print("Max capacity cannot be negative.\nProvide a valid number : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Integer.parseInt(num) <= 0)
                        throw new NegativeNumberException();
                    this.maxCapacity = Integer.parseInt(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("Max capacity cannot be negative.\nProvide a valid number : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Max capacity given was not a valid number input.\nProvide a valid number : ");
                }
            }
        } catch (InputMismatchException e) {
            System.out.print("Max capacity given was not a valid number input.\nProvide a valid number : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Integer.parseInt(num) <= 0)
                        throw new NegativeNumberException();
                    this.maxCapacity = Integer.parseInt(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("Max capacity cannot be negative.\nProvide a valid number : ");
                } catch (InputMismatchException ex) {
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