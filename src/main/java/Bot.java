import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    //������� ��� ���������, ����������� �� �������� ������ � ��� ���� ��������������
    //������ ��������� ������������ ���� ������
    final private String BOT_TOKEN = "5421274576:AAHfs3ADi4fECQ9UdDR9N5655UHlaGsgX1E";
    final private String BOT_NAME = "TestJavaFirst_bot";
    Storage storage;

    Bot()
    {
        storage = new Storage();
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try{
            if(update.hasMessage() && update.getMessage().hasText())
            {
                //��������� �� ������� ��������� ������������
                Message inMess = update.getMessage();
                //������� �� inMess id ���� ������������
                String chatId = inMess.getChatId().toString();
                //�������� ����� ��������� ������������, ���������� � ���������� ���� ����������
                String response = parseMessage(inMess.getText());
                //������� ������ ������ SendMessage - ��� ������� ����� ������������
                SendMessage outMess = new SendMessage();

                //��������� � ���� ��������� id ���� � ����� ��� �����
                outMess.setChatId(chatId);
                outMess.setText(response);

                //�������� � ���
                execute(outMess);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public String parseMessage(String textMsg) {
        String response;

        //���������� ����� ������������ � ������ ���������, �� ������ ����� ��������� �����
        if(textMsg.equals("/start"))
            response = "�����������, ��� ����� ����� �����. ��� /get, ����� �������� ��������� �� ���";
        else if(textMsg.equals("/get"))
            response = storage.getRandQuote();
        else
            response = "��������� �� ����������";

        return response;
    }
}