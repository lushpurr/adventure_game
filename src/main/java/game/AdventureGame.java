package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdventureGame {

    public static void main(String[] args) throws IOException {
        BufferedReader in;
        String input;
        String output;
        Game game = new Game();
        in = new BufferedReader(new InputStreamReader(System.in));
        game.showIntro();
        do {
            System.out.print("> ");
            input = in.readLine();
            output = game.runCommand(input);
            System.out.println(output);
        } while (!"q".equals(input));
    }

}
