package AdapterPattern;

interface Square {
    int getX();
    int getY();
}
class SquareObj implements Square {
    int x;
    int y;

    public SquareObj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}

interface Circle {
    int getWidth();
}

class CircleObj implements Circle {
    int width;

    public CircleObj(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }
}
class SquareAdapter implements Circle {
    Square square;

    public SquareAdapter(Square square) {
        this.square = square;
    }

    @Override
    public int getWidth() {
        return square.getX();
    }
}

class Test {
    public static void main(String[] args) {
        SquareObj squareObj = new SquareObj(2,3);

        SquareAdapter squareAdapter = new SquareAdapter(squareObj);
        System.out.println(squareAdapter.getWidth());
    }
}
