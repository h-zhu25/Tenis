package Model;

import Model.Player;

public class Service {

        private Player currentServer;
        private int faultCount; // 记录发球失误的次数

        public Service(Player server) {
            this.currentServer = server;
            this.faultCount = 0;
        }

        // 获取当前的发球方
        public Player getCurrentServer() {
            return currentServer;
        }

        // 记录一次发球失误
        public void addFault() {
            faultCount++;
        }

        // 检查是否是双发失误
        public boolean isDoubleFault() {
            return faultCount >= 2;
        }

        // 重置发球失误计数
        public void resetFaults() {
            faultCount = 0;
        }
    }


