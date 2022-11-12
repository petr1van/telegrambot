import java.util.ArrayList;

public class Storage {
    private ArrayList<String> quoteList;
    Storage()
    {
        quoteList = new ArrayList<>();
        quoteList.add("�������� ������ ����� � ����, ��� ���� ��������. \n\n����� ����������.");
        quoteList.add("80% ������ - ��� ��������� � ������ ����� � ������ �����.\n\n���� �����");
        quoteList.add("�� ������ �������� ���������: �������� ���� ��,��� ����� ������.\n\n������ ������");
    }

    String getRandQuote()
    {
        //�������� ��������� �������� � ��������� �� 0 �� ������ �������� �������
        int randValue = (int)(Math.random() * quoteList.size());
        //�� ��������� �������� ������ �� ��������� �������� � ���������� ��
        return quoteList.get(randValue);
    }
}