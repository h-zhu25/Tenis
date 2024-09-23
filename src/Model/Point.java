package Model;

public class Point {

        private PointType pointType;

        public Point() {
            this.pointType = PointType.ZERO; // 默认从 0 开始
        }

        public PointType getPointType() {
            return pointType;
        }

        public void scorePoint() {
            switch (pointType) {
                case ZERO:
                    pointType = PointType.FIFTEEN;
                    break;
                case FIFTEEN:
                    pointType = PointType.THIRTY;
                    break;
                case THIRTY:
                    pointType = PointType.FORTY;
                    break;
                case FORTY:
                    pointType = PointType.ADVANTAGE;
                    break;
                case ADVANTAGE:
                    pointType = PointType.ZERO; // 游戏结束，重置
                    break;
            }
        }

        @Override
        public String toString() {
            return pointType.getValue();
        }
    }


