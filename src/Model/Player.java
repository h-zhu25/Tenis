package Model;


import java.util.ArrayList;
import java.util.List;

    public class Player {
        private String name;
        private int id;
        private List<MatchHistory> matchHistories;
        private int points;
        private boolean isServing;
        private int[] setWins;
        private boolean fault = false;  // 是否发球失误

        public void setFault(boolean fault) {
            this.fault = fault;
        }

        public boolean isFault() {
            return fault;
        }



        public Player(String name, int id,int setsCount) {
            this.name = name;
            this.id = id;
            this.points = 0;
            this.isServing = false;
            this.matchHistories = new ArrayList<>();
            this.setWins = new int[setsCount];
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
        public int[] getSetWins() {
            return this.setWins;  // 返回玩家当前的获胜局数
        }

        public List<MatchHistory> getMatchHistories() {
            return matchHistories;
        }

        public void addMatchHistory(MatchHistory history) {
            matchHistories.add(history);
        }

        public void winPoint() {
            if (points < 3) {
                points++;  // 从 0, 15, 30 到 40 增加
            } else {
                points = 4;  // 达到 40 后，进入 AD 或赢得游戏
            }
        }
        public void resetPoints() {
            points = 0;
        }

        public int getPoints() {
            return this.points;
        }

        public void setServing(boolean isServing) {
            this.isServing = isServing;
        }

        public boolean isServing() {
            return isServing;
        }

        public void winSet() {
            this.setWins[0]++;  // 更新玩家赢得的set数量
        }

    }



