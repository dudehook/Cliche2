package net.dudehook.cliche2;

import java.util.ArrayList;
import java.util.List;

public class DedicatedShell extends Shell
{
    private String command;

    public DedicatedShell(Settings s, CommandTable commandTable, String command, List<String> path)
    {
        super(s, commandTable, path);
        // TODO Auto-generated constructor stub
        this.command = command;
    }

    @Override
    public void processLine(String line) throws CLIException
    {
        if (line.trim().equals("?"))
        {
            super.getOuput().output(String.format(HINT_FORMAT, super.getAppName()), super.getOutputConverter());
        }
        else
        {
            List<Token> tokens = new ArrayList<Token>();
            tokens.add(new Token(0, command));
            tokens.add(new Token(1, line));
            processCommand(command, tokens);
        }
    }
}
