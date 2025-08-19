package utilz;

public class Constants {
    public static class PlayerConstants {
        public static final int ATTACK = 0;
        public static final int ATTACK_2 = 1;
        public static final int ATTACK_2_NO_MOVEMENT = 2;
        public static final int ATTACK_COMBO_2_HIT = 3;
        public static final int ATTACK_COMBO_NO_MOVEMENT = 4;
        public static final int ATTACK_NO_MOVEMENT = 5;
        public static final int CROUCH = 6;
        public static final int CROUCH_ATTACK = 7;
        public static final int CROUCH_FULL = 8;
        public static final int CROUCH_TRANSITION = 9;
        public static final int CROUCH_WALK = 10;
        public static final int DASH = 11;
        public static final int DEATH = 12;
        public static final int DEATH_NO_MOVEMENT = 13;
        public static final int FALL = 14;
        public static final int HIT = 15;
        public static final int IDLE = 16;
        public static final int JUMP = 17;
        public static final int JUMP_FALL_INBETWEEN = 18;
        public static final int ROLL = 19;
        public static final int RUN = 20;
        public static final int SLIDE = 21;
        public static final int SLIDE_FULL = 22;
        public static final int SLIDE_TRANSITION_END = 23;
        public static final int SLIDE_TRANSITION_START = 24;
        public static final int TURN_AROUND = 25;
        public static final int WALL_CLIMB = 26;
        public static final int WALL_CLIMB_NO_MOVEMENT = 27;
        public static final int WALL_HANG = 28;
        public static final int WALL_SLIDE = 29;

        public static int GetSpriteAmount(int player_Action) {
            switch (player_Action) {
                case ATTACK:
                    return 4;
                case ATTACK_2:
                    return 6;
                case ATTACK_2_NO_MOVEMENT:
                    return 6;
                case ATTACK_COMBO_2_HIT:
                    return 10;
                case ATTACK_COMBO_NO_MOVEMENT:
                    return 10;
                case ATTACK_NO_MOVEMENT:
                    return 4;
                case CROUCH:
                    return 1;
                case CROUCH_ATTACK:
                    return 4;
                case CROUCH_FULL:
                    return 3;
                case CROUCH_TRANSITION:
                    return 1;
                case CROUCH_WALK:
                    return 8;
                case DASH:
                    return 2;
                case DEATH:
                    return 10;
                case DEATH_NO_MOVEMENT:
                    return 10;
                case FALL:
                    return 3;
                case HIT:
                    return 1;
                case IDLE:
                    return 10;
                case JUMP:
                    return 3;
                case JUMP_FALL_INBETWEEN:
                    return 2;
                case ROLL:
                    return 12;
                case RUN:
                    return 10;
                case SLIDE:
                    return 2;
                case SLIDE_FULL:
                    return 4;
                case SLIDE_TRANSITION_END:
                    return 1;
                case SLIDE_TRANSITION_START:
                    return 1;
                case TURN_AROUND:
                    return 3;
                case WALL_CLIMB:
                    return 7;
                case WALL_CLIMB_NO_MOVEMENT:
                    return 7;
                case WALL_HANG:
                    return 1;
                case WALL_SLIDE:
                    return 3;
                default:
                    return 16;
            }
        }

    }
}