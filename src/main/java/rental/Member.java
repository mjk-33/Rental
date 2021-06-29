package rental;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member
{
    private String name;
    private String surname;
    private int age;
    private LocalDate joinDate;
    private int penalty;
    protected boolean blocked;
    public List<String> history;

    public Member(String name, String surname, int age)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.joinDate = LocalDate.now();
        this.penalty = penalty;
        this.blocked = false;
        this.history = new ArrayList<>();
    }
    public String getName()
    {
        return this.name;
    }

    public String getSurname()
    {
        return this.surname;
    }

    public int getAge()
    {
        return age;
    }

    public String getRegisterDate()
    {
        return this.joinDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public float getPenalty()
    {
        return this.penalty;
    }

    public boolean isBlocked()
    {
        return this.blocked;
    }

    public String getBlockStatus()
    {
        if (this.blocked)
        {
            return "Blocked";
        }
        return "Active";
    }

    public void addPenalty(float penalty)
    {
        this.penalty += penalty;
    }

    public void blockUser()
    {
        this.blocked = true;
    }

    public void unblockUser()
    {
        this.blocked = false;
    }

    public void addHistory(String check)
    {
        this.history.add(check);
    }



}
