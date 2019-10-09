// package dat240.project.Gruppe2;

// import java.io.File;
// import javax.imageio.ImageIO;
// import java.awt.Graphics;
// import java.awt.image.BufferedImage;
// import java.io.IOException;
// import java.util.HashMap;

// import dat240.project.Gruppe2.Image;



// public class getimages {
//     public void pngreader()  throws IOException{
//         File imagefile = new File("task 2 scattered images/ILSVRC2012_val_00000122_scattered");
//         File imagefolder = new File("task 2 scattered images pc");
//         // File file = new File("ILSVRC2012_val_00000086_scattered");
//         // System.out.println(file);
//         // BufferedImage bilde = ImageIO.read(file);
//         //mapsegments(bilde, 1);
//         File[] listoffiles = imagefolder.listFiles((dir, name) -> !name.equals(".DS_Store"));    
//         int num = 0;
//             for(File folder: listoffiles){
//                 BufferedImage pngpart = null; 
//                 BufferedImage test= null; 
//                 String filepath = folder.getPath();
//                 File image = new File(filepath.replaceAll("\\\\", "/"));
//                 File[]pngparts = image.listFiles();

//                 BufferedImage img = new BufferedImage(test.getWidth(), test.getHeight(), BufferedImage.TYPE_INT_RGB);
//                 num++;
//                 for (File f : image.listFiles()) {
//                     try {
//                         Image bildet = new Image(num,pngparts);
//                         pngpart = ImageIO.read(f);
//                         Graphics g = img.getGraphics();
//                         g.drawImage(pngpart,0,0,null);
//                     } catch (final IOException e) {}
//                 }
//             System.out.println("Picture: "+num);
//             ImageIO.write(img,"png",new File("pictures/picture"+num+".png"));
//         }
//     }
//     public HashMap mapsegments(BufferedImage file,int id){
//         HashMap<String,Integer> hashmap = new HashMap<>();
//         for (int i = 0; i < file.getHeight(); i++) {
//             for (int j = 0; j < file.getWidth(); j++) {
//                 String pixel = j + " " + i;
//                 if (isTransparent(file, j, i)==false){
//                     hashmap.put(pixel,id);
//                     System.out.println(pixel);
//                 }
//             }
//         }
//         return hashmap;
//     }

//     public static boolean isTransparent(BufferedImage image, int x, int y ) {
//         int pixel = image.getRGB(x,y);
//         return (pixel>>24) == 0x00;
//     }
// }