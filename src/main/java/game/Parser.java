//package game;
//
//import globals.WordType;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class Parser {
//
//    //   the keyword static indicates that the particular member belongs to a type itself,
////   rather than to an instance of that type. This means that only one instance of that
////   static member is created which is shared across all instances of the class.
//    static HashMap<String, WordType> vocab = new HashMap<>();
//
//    static void initVocab() {
//        vocab.put("sword", WordType.NOUN);
//        vocab.put("test", WordType.VERB);
//        vocab.put("get", WordType.VERB);
//        vocab.put("i", WordType.VERB);
//        vocab.put("inventory", WordType.VERB);
//        vocab.put("take", WordType.VERB);
//        vocab.put("drop", WordType.VERB);
//        vocab.put("put", WordType.VERB);
//        vocab.put("l", WordType.VERB);
//        vocab.put("look", WordType.VERB);
//        vocab.put("open", WordType.VERB);
//        vocab.put("close", WordType.VERB);
//        vocab.put("pull", WordType.VERB);
//        vocab.put("push", WordType.VERB);
//        vocab.put("n", WordType.VERB);
//        vocab.put("s", WordType.VERB);
//        vocab.put("w", WordType.VERB);
//        vocab.put("e", WordType.VERB);
//        vocab.put("up", WordType.VERB);
//        vocab.put("down", WordType.VERB);
//        vocab.put("q", WordType.VERB);
//        vocab.put("quit", WordType.VERB);
//        vocab.put("a", WordType.ARTICLE);
//        vocab.put("an", WordType.ARTICLE);
//        vocab.put("the", WordType.ARTICLE);
//        vocab.put("in", WordType.PREPOSITION);
//        vocab.put("into", WordType.PREPOSITION);
//        vocab.put("at", WordType.PREPOSITION);
//    }
//
//    static String processVerbNounPrepositionNoun(List<WordAndType> command) {
//        WordAndType wt = command.get(0);
//        WordAndType wt2 = command.get(1);
//        WordAndType wt3 = command.get(2);
//        WordAndType wt4 = command.get(3);
//        String msg = "";
//
//        if ((wt.getWordType() != WordType.VERB) || (wt3.getWordType() != WordType.PREPOSITION)) {
//            msg = "Can't do this because I don't understand how to '" + wt.getWord() + " something " + wt3.getWord() + "' something!";
//
//        } else if (wt2.getWordType() != WordType.NOUN) {
//            msg = "Can't do this because '" + wt2.getWord() + "' is not an object!\r\n";
////            \r\n means new line
//        } else if (wt4.getWordType() != WordType.NOUN) {
//            msg = "Can't do this because '" + wt4.getWord() + "' is not an object!\r\n";
//        } else {
//            switch (wt.getWord() + wt3.getWord()){
////                this will check if first and third word are put in or put into and will put object in container
//                case "putin":
//                case "putinto":
//                    msg = AdventureGame.game.putObjectInContainer(wt2.getWord(), wt4.getWord());
//                    break;
//                default:
//                    msg = "I don't know how to " + wt.getWord() + " " + wt2.getWord() + " " + wt3.getWord() + " " + wt4.getWord() + "!";
//                break;
//            }
//        }
//        return msg;
//        }
//
//    static String processVerbPrepositionNoun(List<WordAndType> command) {
//        // "look at/ look in" are the only implemented commands of this type
//        WordAndType wt = command.get(0);
//        WordAndType wt2 = command.get(1);
//        WordAndType wt3 = command.get(2);
//        String msg = "";
//
//        if ((wt.getWordType() != WordType.VERB) || (wt2.getWordType() != WordType.PREPOSITION)) {
//            msg = "Can't do this because I don't understand '" + wt.getWord() + " " + wt2.getWord() + "' !";
//        } else if (wt3.getWordType() != WordType.NOUN) {
//            msg = "Can't do this because '" + wt3.getWord() + "' is not an object!\r\n";
//        } else {
//            switch (wt.getWord() + wt2.getWord()) {
//                case "lookat":
//                    msg = AdventureGame.game.lookAtOb(wt3.getWord());
//                    break;
//                case "lookin":
//                    msg = AdventureGame.game.lookInOb(wt3.getWord());
//                    break;
//                default:
//                    msg = "I don't know how to " + wt.getWord() + " " + wt2.getWord() + " " + wt3.getWord() + "!";
//                    break;
//            }
//        }
//        return msg;
//    }
//
//    static String processVerbNoun(List<WordAndType> command) {
//        WordAndType wt = command.get(0);
//        WordAndType wt2 = command.get(1);
//        String msg = "";
//
//        if (wt.getWordType() != WordType.VERB) {
//            msg = "Can't do this because '" + wt.getWord() + "' is not a command!";
//        } else if (wt2.getWordType() != WordType.NOUN) {
//            msg = "Can't do this because '" + wt2.getWord() + "' is not an object!";
//        } else {
//            switch (wt.getWord()) {
//                case "take":
//                case "get":
//                    msg = AdventureGame.game.takeOb(wt2.getWord());
//                    break;
//                case "drop":
//                    msg = AdventureGame.game.dropOb(wt2.getWord());
//                    break;
//                case "open":
//                    msg = AdventureGame.game.openOb(wt2.getWord());
//                    break;
//                case "close":
//                    msg = AdventureGame.game.closeOb(wt2.getWord());
//                    break;
//                default:
//                    msg += " (not yet implemented)";
//                    break;
//            }
//        }
//        return msg;
//    }
//
//    static String processVerb(List<WordAndType> command) {
//        WordAndType wt = command.get(0);
//        String msg = "";
//
//        if (wt.getWordType() != WordType.VERB) {
//            msg = "Can't do this because '" + wt.getWord() + "' is not a command!";
//        } else {
//            switch (wt.getWord()) {
//                case "n":
//                    AdventureGame.game.goN();
//                    break;
//                case "s":
//                    AdventureGame.game.goS();
//                    break;
//                case "w":
//                    AdventureGame.game.goW();
//                    break;
//                case "e":
//                    AdventureGame.game.goE();
//                    break;
//                case "up":
//                    AdventureGame.game.goUp();
//                    break;
//                case "down":
//                    AdventureGame.game.goDown();
//                    break;
//                case "l":
//                case "look":
//                    AdventureGame.game.look();
//                    break;
//                case "inventory":
//                case "i":
//                    AdventureGame.game.showInventory();
//                    break;
//                case "test":
//                    AdventureGame.game.test();
//                    break;
//                default:
//                    msg = wt.getWord() + " (not yet implemented)";
//                    break;
//            }
//        }
//        return msg;
//    }
//
////    this function initialises different functions depending on the length of the command given
//    static String processCommand(List<WordAndType> command) {
//        String s = "";
//
//        if (command.size() == 0) {
//            s = "You must write a command!";
//        } else if (command.size() > 4) {
//            s = "That command is too long!";
//        } else {
//            switch (command.size()) {
//                case 1:
//                    s = processVerb(command);
//                    break;
//                case 2:
//                    s = processVerbNoun(command);
//                    break;
//                case 3:
//                    s = processVerbPrepositionNoun(command);
//                    break;
//                case 4:
//                    s = processVerbNounPrepositionNoun(command);
//                    break;
//                default:
//                    s = "Unable to process command";
//                    break;
//            }
//        }
//        return s;
//    }
//
//
//    static String parseCommand(List<String> wordlist) {
//        List<WordAndType> command = new ArrayList<>();
//        WordType wordtype;
//        String errmsg = "";
//        String msg;
//
//        for (String k : wordlist) {
//            if (vocab.containsKey(k)) {
//                wordtype = vocab.get(k);
//                if (wordtype == WordType.ARTICLE) {       // ignore articles
//                } else {
//                    command.add(new WordAndType(k, wordtype));
//                }
//            } else { // if word not found in vocab
//                command.add(new WordAndType(k, WordType.ERROR));
//                errmsg = "Sorry, I don't understand '" + k + "'";
//            }
//        }
//        if (!errmsg.isEmpty()) {
//            msg = errmsg;
//        } else {
//            msg = processCommand(command);
//        }
//        return msg;
//    }
//
//    //removes unwanted characters
//    static List<String> wordList(String input) {
//        String delims = "[ \t,.:;?!\"']+";
//        List<String> strlist = new ArrayList<>();
//        String[] words = input.split(delims);
//
//        for (String word : words) {
//            strlist.add(word);
//        }
//        return strlist;
//    }
//
//
//
//    }
//
