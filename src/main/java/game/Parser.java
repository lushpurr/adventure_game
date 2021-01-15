package game;

import globals.WordType;

import java.util.HashMap;
import java.util.List;

public class Parser {

    //   the keyword static indicates that the particular member belongs to a type itself,
//   rather than to an instance of that type. This means that only one instance of that
//   static member is created which is shared across all instances of the class.
    static HashMap<String, WordType> vocab = new HashMap<>();

    static void initVocab() {
        vocab.put("sword", WordType.NOUN);
        vocab.put("pick up", WordType.VERB);
        vocab.put("a", WordType.ARTICLE);
        vocab.put("the", WordType.ARTICLE);
        vocab.put("at", WordType.PREPOSITION);
    }

    static String processVerbNounPrepositionNoun(List<WordAndType> command) {
        WordAndType wt = command.get(0);
        WordAndType wt2 = command.get(1);
        WordAndType wt3 = command.get(2);
        WordAndType wt4 = command.get(3);
        String msg = "";

        if ((wt.getWordType() != WordType.VERB) || (wt3.getWordType() != WordType.PREPOSITION)) {
            msg = "Can't do this because I don't understand how to '" + wt.getWord() + " something " + wt3.getWord() + "' something!";

        } else if (wt2.getWordType() != WordType.NOUN) {
            msg = "Can't do this because '" + wt2.getWord() + "' is not an object!\r\n";
//            \r\n means new line
        } else if (wt4.getWordType() != WordType.NOUN) {
            msg = "Can't do this because '" + wt4.getWord() + "' is not an object!\r\n";
        } else {
            switch (wt.getWord() + wt3.getWord()){
//                this will check if first and third word are put in or put into and will put object in container
                case "putin":
                case "putinto":
                    msg = AdventureGame.game.putObjectInContainer(wt2.getWord(), wt4.getWord());
                    break;
                default:
                    msg = "I don't know how to " + wt.getWord() + " " + wt2.getWord() + " " + wt3.getWord() + " " + wt4.getWord() + "!";
                break;
            }
        }
        return msg;
        }


    }

