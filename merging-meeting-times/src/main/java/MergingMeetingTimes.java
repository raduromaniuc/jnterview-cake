import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergingMeetingTimes {

    public static void main(String[] args) {
        List<Meeting> meetings = Arrays.asList(
                new Meeting(0, 1), new Meeting(3, 5),
                new Meeting(4, 8), new Meeting(10, 12),
                new Meeting(9, 10)
        );

        System.out.println(mergeMeetings(meetings));
    }

    public static List<Meeting> mergeMeetings(List<Meeting> meetings) {
        meetings.sort(Comparator.comparingInt(Meeting::getStart));

        List<Meeting> mergedMeetings = new ArrayList<>();

        Meeting c = meetings.get(0);

        for (Meeting m : meetings) {
            if(m.start > c.end) {
                mergedMeetings.add(c);
                c = m;
            } else if(m.end > c.end) {
                c.end = m.end;
            }
        }
        mergedMeetings.add(c);

        return mergedMeetings;
    }
}