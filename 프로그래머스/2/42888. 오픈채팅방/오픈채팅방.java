import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public static String[] solution(String[] record)  {
        // uid -> 마지막 닉네임 매핑
        Map<String, String> uidToNick = new HashMap<>();
        // Enter, Leave 기록만 조장
        List<String[]> actions = new ArrayList<>();

        for (String rec : record) {
            String[] parts = rec.split(" ");
            String op = parts[0];
            String uid = parts[1];

            if (op.equals("Enter")){
                String nick = parts[2];
                uidToNick.put(uid, nick);
                actions.add(new String[]{"Enter", uid});
            } else if (op.equals("Leave")){
                actions.add(new String[]{"Leave", uid});
            } else{
                String newNick = parts[2];
                uidToNick.put(uid, newNick); // 닉네임만 갱신
            }
        }

        String[] answer = new String[actions.size()];
        int idx = 0;
        for (String[] act : actions) {
            String type = act[0];
            String uid = act[1];
            String nick = uidToNick.get(uid);

            if (type.equals("Enter")){
                answer[idx++] = nick + "님이 들어왔습니다.";
            } else{
                answer[idx++] = nick + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}