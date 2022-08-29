/*  Stephen Fitzpatrick
    21263213
    CS4222
 */


import java.util.Arrays;

public class Image {
    private int[][] pixels;
    private int width;
    private int height;

    public Image(int[][] pixels) {
        this.pixels = pixels;
        this.height = pixels.length;
        this.width = pixels[0].length;

    }

    public String toString() {
        return Arrays.deepToString(pixels);
    }

    public void flip(boolean horizontal) {
        if (horizontal) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width / 2; j++) {
                    int columnFlip = width - 1 - j;
                    int temp = pixels[i][j];
                    pixels[i][j] = pixels[i][columnFlip];
                    pixels[i][columnFlip] = temp;               // 3x3 2D array, i = 0, j = 0:
                                                                // columnFlip = 3-1-0 = 2, temp = pixels[0][0]
                }                                               // pixels[0][0] = pixels[0][2]
                                                                // pixels[0][2] = pixels[0][0]
            }
        } else {
            for (int i = 0; i < height / 2; i++) {
                int rowFlip = height - 1 - i;
                int[] temp = pixels[i];
                pixels[i] = pixels[rowFlip];
                pixels[rowFlip] = temp;                         //3x3 2D array, i = 0,  j = 0
            }                                                   //rowFlip = 3-1-0 = 2, temp[0] = pixels[0]
                                                                //pixels[0] = pixels[2]
                                                                //pixels[2] = pixels[0]
        }
    }

    public void rotate(boolean clockwise) {
        //Initializing new array
        int[][] rotatedImage = new int[width][height];

        if(clockwise){
            for(int i=0; i < height; i++){
                for(int j=0; j < width; j++) {
                    rotatedImage[j][height - 1 - i] = pixels[i][j]; // 3x3 2D array example: (row --> column)
                                                                    // rotatedImage[0][2] = pixels[0][0]
                                                                    // rotatedImage[0][1] = pixels[1][0]
                }                                                   // rotatedImage[0][0] = pixels[2][0]
            }
        } else {
            for(int i=0; i < height; i++){
                for(int j=0; j < width; j++){
                    rotatedImage[width-1-j][i] = pixels[i][j];      // 3x3 2D array example: (column --> row)
                                                                    // rotatedImage[2][0] = pixels[0][0] i = 0, j = 0
                }                                                   // rotatedImage[1][0] = pixels[0][1] i = 0, j = 1
            }                                                       // rotatedImage[0][0] = pixels[0][2] i = 0, j = 2
        }
        this.pixels = rotatedImage;
        int updatedHeight = width;
        int updatedWidth = height;
        this.height = updatedHeight;
        this.width = updatedWidth;
    }
}








