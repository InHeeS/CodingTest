class Solution {
    static int[] percent = {0,10,20,30,40};
    static int min = Integer.MAX_VALUE, total_price = 0, total_join = 0;

    public static int[] solution(int[][] users, int[] emoticons) {
        // 플로스 가입자 -> 판매액 늘리기
        // users = {percent, limit}
        int[] answer = {};
        for (int[] user : users) {
            min = Math.min(min, user[0]);
        }

        for (int i = 0; i < 5; i++) {
            if (min <= percent[i]) {
                min = i;
                break;
            }
        }

        // 중복 조합
        int[] discounts = new int[emoticons.length];
        comb(discounts, 0, emoticons.length, users, emoticons);

        return new int[]{total_join, total_price};

    }

    private static void comb(int[] discounts, int s, int n, int[][] users, int[] emoticons) {
        if (s == n) {
            cal(users, emoticons, discounts);
            return;
        }
        for (int i = s; i < n; i++) {
            for (int j = min; j < 5; j++) {
                discounts[i] = percent[j];
                comb(discounts, i + 1, n, users, emoticons);
            }
        }
    }

    private static void cal(int[][] users, int[] emoticons, int[] discounts) {
        int join = 0; //플러스 가입 수
        int price = 0; //판매액

        for (int[] user : users) {
            int userMinDiscount = user[0]; // 할인률
            int userMaxPay = user[1]; // 리밋 가격
            int sum = 0;

            for (int i = 0; i < discounts.length; i++) {
                // 이럴 가능성이 존재하는가?
                // min = 유저중 가장 할인율이 낮은 사람의 인덱스
                // 할인이 만약에 아무도 되지 않는다면 0프로
                if (discounts[i] < userMinDiscount) continue;
                sum += sale(emoticons[i], discounts[i]);
            }

            // 기준점 이상이면 가입, 아니면 구입
            if (userMaxPay <= sum)
                join++;
            else
                price += sum;
        }
        // static 변수
        if (join > total_join) {
            total_join = join;
            total_price = price;
        } else if (join == total_join && price > total_price) {
            total_price = price;
        }
    }

    private static int sale(int price, int percent) {
        return (price / 100) * (100 - percent);
    }
}