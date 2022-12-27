
import java.util.Scanner;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import implement.ArrayList;
import implement.Queue2;
import implement.Stack;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author Yudlee
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        Queue2<String> queue = new Queue2<String>();
        Stack<String> stack = new Stack<String>();
        ArrayList<String> tempSpam = new ArrayList<String>();
        ArrayList<String> spam = new ArrayList<String>();
        ArrayList<String> historyDisplay = new ArrayList<String>();
        ArrayList<String> historyStorage = new ArrayList<String>();
        boolean isRunning = true;
        while (isRunning) {
            try {
                // Get input array
                String[] sentences = inputMessage();

                // Begin process
                long startTime = System.nanoTime();
                transportMessage(sentences, queue, historyDisplay, historyStorage, spam);

                // Store and print
                processMessage(sentences, stack, queue);
                long stopTime = System.nanoTime();
                System.out.println("Your process takes " + (stopTime - startTime) + "ns\n");
                showMessage(stack, tempSpam);

                // handle
                isRunning = handle(historyDisplay, historyStorage, tempSpam, spam);
            } catch (IOException io) {
                System.out.println("Error: You haven't typed anything yet");
            } catch (Exception e) {
                System.out.println("Error: An error occurred, please try again.");
            }
        }
    }

    private static boolean handle(ArrayList<String> historyDisplay, ArrayList<String> historyStorage,
                                  ArrayList<String> tempSpam, ArrayList<String> spam) {
        System.out.println("""
                0. Handle with spam
                1. History
                2. Quit;
                Press enter to skip""");
        // Get choice
        System.out.print("Your choice: ");
        String choice = sc.nextLine();
        choice=choice.trim();
        while (!choice.equals("0") && !choice.equals("1") && !choice.equals("2") && !choice.equals("")) {
            System.out.print("Your choice: ");
            choice = sc.nextLine();
            choice=choice.trim();
        }
        System.out.println();
        // Swith choice
        switch (choice) {
            case "0":
                handleSpam(tempSpam, spam);
                return true;
            case "1":
                handleHistory(historyDisplay, historyStorage);
                return true;
            case "2":
                return false;
            default:
                return true;
        }
    }

    private static void handleSpam(ArrayList<String> tempSpam, ArrayList<String> spam) {
        while (true) {
            System.out.println("""
                0. Mark previously message as spam
                1. Remove specified sentence
                2. Delete spam list
                3. View spam list
                Press enter to skip""");

            // Get choice
            System.out.print("Your choice: ");
            String choiceSpam = sc.nextLine();
            choiceSpam=choiceSpam.trim();
            while (!choiceSpam.equals("0") && !choiceSpam.equals("1") &&
                    !choiceSpam.equals("2") && !choiceSpam.equals("3") &&!choiceSpam.equals("")) {
                System.out.print("Your choice: ");
                choiceSpam = sc.nextLine();
                choiceSpam=choiceSpam.trim();
            }

            // Switch choice
            if (choiceSpam.equals("0")) {
                // Check tempSpam is empty
                if (tempSpam.isEmpty()) {
                    System.out.println("Nothing to add");
                } else {
                    while (!tempSpam.isEmpty()) {
                        // Poll all item in temSpam to add to spam
                        while (!tempSpam.isEmpty()) {
                            spam.add(tempSpam.remove(0));
                        }
                        System.out.println("Add message to spam list successfully");
                    }
                }
                System.out.println();
            }else if (choiceSpam.equals("1")) {
                // Get sentence to delete
                System.out.print("Sentence: ");
                String sentence = sc.nextLine();
                // check contains
                if (spam.contains(sentence)) {
                    // remove the sentence from spam
                    spam.remove(spam.getIndex(sentence));
                    System.out.println("That sentence has been delete in spam list");
                } else {
                    System.out.println("That sentence is not on the spam list");
                }
                System.out.println();
            } else if(choiceSpam.equals("2")) {
                // Check spam is empty
                if (spam.isEmpty()) {
                    System.out.println("Nothing to delete");
                } else {
                    while (!spam.isEmpty()) {
                        spam.remove(0);
                    }
                    System.out.println("Delete all spam list successfully");
                    System.out.println();
                }
            } else if(choiceSpam.equals("3")) {
                if (spam.isEmpty()) {
                    System.out.println("No records found");
                    System.out.println();
                } else {
                    // Show spam list
                    System.out.println("Spam List:");
                    System.out.println(spam);
                }
            } else {
                break;
            }
        }
    }

    private static void handleHistory(ArrayList<String> historyDisplay, ArrayList<String> historyStorage) {
        while (true) {
            // check the history is empty
            if (historyDisplay.isEmpty()) {
                System.out.println("History: No records found");
                break;
            }
            else {
                System.out.println("------------------------------------------");
                System.out.println("History:\n" + historyDisplay);
                System.out.println("------------------------------------------");
                System.out.println("""
                        0. Remove specified sentence
                        1. Delete all history;
                        2. Find history
                        Press enter to skip""");
                // Get choice
                System.out.print("Your choice: ");
                String choiceHistory = sc.nextLine();
                choiceHistory=choiceHistory.trim();
                while (!choiceHistory.equals("0") && !choiceHistory.equals("1") &&
                        !choiceHistory.equals("2") && !choiceHistory.equals("")) {
                    System.out.print("Your choice: ");
                    choiceHistory = sc.nextLine();
                    choiceHistory=choiceHistory.trim();
                }
                System.out.println();

                if (choiceHistory.equals("0")) {
                    // Get sentence to remove
                    System.out.print("Sentence: ");
                    String sentence = sc.nextLine();
                    // Check if the historyStorage contain sentence
                    if (historyStorage.contains(sentence)) {
                        // Get the index of the item the client want to delete
                        int indexRemove = historyStorage.getIndex(sentence);
                        // delete in two history
                        historyStorage.remove(indexRemove);
                        historyDisplay.remove(indexRemove);
                        System.out.println("That sentence has been delete in history");
                    } else {
                        System.out.println("That sentence is not on the history");
                    }
                    System.out.println();
                } else if (choiceHistory.equals("1")) {
                    // Delete two list history
                    while (!historyDisplay.isEmpty()) {
                        historyDisplay.remove(0);
                    }
                    while (!historyStorage.isEmpty()) {
                        historyStorage.remove(0);
                    }
                    System.out.println("Delete all history successfully");
                    System.out.println();
                } else if (choiceHistory.equals("2")) {
                    // Get the sentence the client want to find
                    System.out.print("Sentence: ");
                    String sentence = sc.nextLine();
                    // Get all index of all sentences matched
                    ArrayList<Integer> indexesFind = historyStorage.getMultipleIndex(sentence);
                    // Check if the list is empty
                    if (indexesFind.isEmpty()) {
                        System.out.println("No records found");
                    } else {
                        System.out.println("All records match: ");
                        // Loop for all list and display all result
                        for (int i =0; i< indexesFind.size(); i++) {
                            String result = historyDisplay.get(indexesFind.get(i));
                            System.out.println(result);
                        }
                    }
                    System.out.println();
                } else {
                    break;
                }
            }
        }
    }



    private static void showMessage(Stack<String> stack, ArrayList<String> tempSpam) {
        while (!tempSpam.isEmpty()) {
            // Poll all item in temSpam after begin new process
            tempSpam.remove(0);
        }
        // Loop for all item in stack
        while (!stack.isEmpty()) {
            // Add to temp spam
            tempSpam.add(stack.peek());
            // Print message by pop all item in stack
            System.out.println("You received a new message: " + stack.pop());
        }
        System.out.println();
    }

    private static void processMessage(String[] sentences, Stack<String> stack, Queue2<String> queue) {
        // Poll all item in queue to add to stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
    }

    private static void transportMessage(String[] sentences, Queue2<String> queue, ArrayList<String> historyDisplay, ArrayList<String> historyStorage, ArrayList<String> spam) throws Exception {
        // Format time to add story
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        for (int i =0; i< sentences.length; i++) {
            try {
                if (sentences[i].length()> 250) {
                    throw new IndexOutOfBoundsException();
                } else if(sentences[i].equals("")) {
                    throw new IOException();
                }
                else if (spam.contains(sentences[i])) {
                    System.out.println("Your message is considered spam");
                } else {
                    // Add to queue
                    queue.offer(sentences[i]);
                    System.out.println("Your message has been sent successfully");
                    // Add to history
                    Date date = new Date();
                    historyDisplay.add(dateFormat.format(date) + ": " + sentences[i]);
                    historyStorage.add(sentences[i]);
                }
            }  catch (IndexOutOfBoundsException ie) {
                System.out.println("Error: The message has exceeded 250 characters");
            } catch (IOException io) {
                System.out.println("Error: You haven't typed anything yet");
            } catch (Exception e) {
                System.out.println("Error: An error occurred, please try again.");
            }
        }
    }

    private static String[] inputMessage() throws IOException {
        System.out.print("Message: ");
        String message = sc.nextLine();
        if (message.equals("")) {
            throw new IOException();
        }
        String[] sentences =  message.split(";");
        for (int i = 0; i<sentences.length; i++) {
            // Remove space
            sentences[i] = sentences[i].trim();
        }
        return sentences;
    }
}


