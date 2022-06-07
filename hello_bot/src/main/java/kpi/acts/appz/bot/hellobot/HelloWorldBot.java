package kpi.acts.appz.bot.hellobot;

import kpi.acts.appz.bot.Bot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.api.objects.Update;

public final class HelloWorldBot extends Bot {
    public static void main(String[] args){
        if(args == null || args.length != 2){
            System.out.println("You must run bot with 2 args - BotToken and bot UserName");
        } else {
            ApiContextInitializer.init();
            Bot.runBot(new HelloWorldBot(args[0], args[1]));
        }
    }

    private HelloWorldBot(String token, String botName) {
        super(token, botName);
    }

    @Override
    protected void processTheException(Exception e) {
        e.printStackTrace();
        System.out.println(e.toString());
    }

    @Override
    public void onUpdateReceived(Update update) {
        sendTextMessage(update.getMessage(), "Hello world!");
    }
}
