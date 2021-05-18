package mapGUI;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MapGUI extends JPanel {
    private class Line {
        private final int x1;
        private final int y1;
        private final int x2;
        private final int y2;

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    private final int windowWidth;
    private final int windowHeight;
    LinkedList<Line> lines;
    LinkedList<Polygon> polygons;

    public MapGUI(int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.lines = new LinkedList<>();
        this.polygons = new LinkedList<>();
    }

    public void addLine(int x1, int y1, int x2, int y2) {
        Line line = new Line(x1, y1, x2, y2);
        this.lines.add(line);
    }

    public void addPolygon(Vector<Integer> xs, Vector<Integer> ys) {
        int n = xs.size();
        Polygon poly = new Polygon();
        for(int i = 0; i < n; i++)
            poly.addPoint(xs.get(i), ys.get(i));
        this.polygons.add(poly);
    }

    public void drawMap() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setLayout(null);

        this.setLayout(null);
        frame.setVisible(true);
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setSize(this.windowWidth, this.windowHeight);
        this.setLocation(0, 0);

        Iterator<Line> lineIterator = this.lines.iterator();
        Line line;
        while(lineIterator.hasNext()) {
            line = lineIterator.next();
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
        }

        g.setColor(new Color(50, 255, 50));
        g.fillRect(0, 0, windowWidth, windowHeight);

        Iterator<Polygon> polyIterator = this.polygons.iterator();
        Polygon poly;
        while(polyIterator.hasNext()) {
            poly = polyIterator.next();
            g.setColor(new Color(0, 100, 0));
            g.fillPolygon(poly);
        }
    }

    @Override public Dimension getPreferredSize() {
        return new Dimension(this.windowWidth, this.windowHeight);
    }
}