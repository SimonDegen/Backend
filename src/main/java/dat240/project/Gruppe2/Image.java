package dat240.project.Gruppe2;

import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Image {
    private double id = 0 ;
    public File segments;
    public HashMap<String,Integer> hashmap;
    public String path;
    public ArrayList<BufferedImage> segmenter;

    public Image(int id,String filepath){
        this.id= id;
        this.path = filepath;
        ArrayList<BufferedImage> segmenter = new ArrayList<>();
        HashMap<String,Integer> hashmap = new HashMap<>();
        this.hashmap = hashmap;
        this.segmenter = segmenter;
    }

    public void generateimage() throws IOException {
        BufferedImage test= null; 
        BufferedImage png = null;
        File image = new File(path);
        File[]pngparts = image.listFiles((dir, name) -> !name.equals(".DS_Store")); 
        test = ImageIO.read(pngparts[1]);
        BufferedImage img = new BufferedImage(test.getWidth(), test.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (File f : image.listFiles()) {
            try {
                png = ImageIO.read(f);
                if(png != null){
                    png = mapsegments(png);
                    this.segmenter.add(png);
                }
                Graphics g = img.getGraphics();
                g.drawImage(png,0,0,null);
            } catch (final IOException e) {}
        }
        ImageIO.write(img,"png",new File("pictures/Image.png"));
    }
    
    public BufferedImage mapsegments(BufferedImage bilde){
        int id = 0;
        int tempid = 0;
        Color farge = new Color(255,0,0);
        for (int i = 0; i < bilde.getHeight(); i++) {
            for (int j = 0; j < bilde.getWidth(); j++) {
                String pixel = j + " " + i;
                if (isTransparent(bilde, j, i)==false){
                    if(checkborders(j, i, bilde)){
                        bilde.setRGB(j,i,farge.getRGB());
                    }
                    this.hashmap.put(pixel,id);
                }
            }
            id++;
        }
        return bilde;
    }

    public int getId(int x, int y){
        String key = x + " "+ y;
        return hashmap.get(key);
    }

    public static boolean isTransparent(BufferedImage image, int x, int y ) {
        int pixel = image.getRGB(x,y);
        return (pixel>>24) == 0x00;
    }
    
    public boolean checkborders(int x,int y, BufferedImage bildet){
        if(x>0&&x<bildet.getWidth()-1&&y>0&&y<bildet.getHeight()-1){
            if(isTransparent(bildet, x-1, y)==true) return true;
        
            if(isTransparent(bildet, x+1, y)==true) return true;
        
            if(isTransparent(bildet, x, y-1)==true) return true;
      
            if(isTransparent(bildet, x, y+1)==true) return true;
        }
        return false;
    }






}