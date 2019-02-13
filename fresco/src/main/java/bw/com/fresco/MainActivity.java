package bw.com.fresco;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    private Button cilre;
    private SimpleDraweeView draweeView;
    private Uri uri;
    private boolean c;
    private Uri uri1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cilre = findViewById(R.id.cilre);
        Button bili = findViewById(R.id.bili);
        Button gif = findViewById(R.id.gif);
        Button yj = findViewById(R.id.yj);
        Button huancun = findViewById(R.id.huancun);
     //   Button xuanzhuan = findViewById(R.id.xuanzhuan);
        Button jianjin = findViewById(R.id.jianjin);
        uri = Uri.parse("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL");
        uri1 = Uri.parse("https://n.sinaimg.cn/tech/transform/427/w170h257/20190211/B6kn-hswimzx9195696.gif");
       gif.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ControllerListener controllerListener = new BaseControllerListener<ImageInfo>(){
                   @Override
                   public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                     //  super.onFinalImageSet(id, imageInfo, animatable);
                        if (animatable!=null){
                            animatable.start();
                        }else {
                            animatable.stop();
                        }
                   }
               };
               DraweeController controller = Fresco.newDraweeControllerBuilder()
                       .setUri(uri1)
                       .setControllerListener(controllerListener)
                      // .setAutoPlayAnimations(true)
                       .build();
               draweeView.setController(controller);
           }
       });
       huancun.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ImagePipeline imagePipeline = Fresco.getImagePipeline();

               boolean inMemoryCache = imagePipeline.isInBitmapMemoryCache(uri);
                DataSource<Boolean> inDiskCacheSource = imagePipeline.isInDiskCache(uri);
               DataSubscriber<Boolean> subscriber = new BaseDataSubscriber<Boolean>() {
                   @Override
                   protected void onNewResultImpl(DataSource<Boolean> dataSource) {
                       if (!dataSource.isFinished()){
                            return;
                       }
                       boolean isInCache = dataSource.getResult();
                      final Executor execytor;
                   }

                   @Override
                   protected void onFailureImpl(DataSource<Boolean> dataSource) {

                   }

               };

            //   inDiskCacheSource.subscribe(subscriber,);
           }
       });
        yj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
              /*  if (c == true){
                    roundingParams.setRoundAsCircle(true);
                    c=false;
                }else {
                    roundingParams.setRoundAsCircle(false);
                    c = true;
                }*/
                roundingParams.setCornersRadius(100);
                draweeView.getHierarchy().setRoundingParams(roundingParams);
            }
        });
        //设置比例1:2
        bili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                draweeView.setAspectRatio(2.0f);

            }
        });

        //渐进式

        jianjin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setProgressiveRenderingEnabled(true)

                        .build();
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)

                        .setOldController(draweeView.getController())
                        .build();
                draweeView.setController(controller);
            }
        });
        draweeView = findViewById(R.id.my_image_view);
         draweeView.setImageURI(uri);
        //设置圆形
        c = true;
        cilre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
                if (c == true){
                    roundingParams.setRoundAsCircle(true);
                    c=false;
                }else {
                    roundingParams.setRoundAsCircle(false);
                    c = true;
                }

                draweeView.getHierarchy().setRoundingParams(roundingParams);
            }
        });


    }
}
