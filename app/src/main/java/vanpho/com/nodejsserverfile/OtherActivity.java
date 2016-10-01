package vanpho.com.nodejsserverfile;

/**
 * Created by MyPC on 29/09/2016.
 */
public class OtherActivity {
}
/*
package vanpho.com.nodejsserverfile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {
    private final String CLIENT_SEND_IMAGE = "CLIENT_SEND_IMAGE";
    private final String SERVER_SEND_IMAGE = "SERVER_SEND_IMAGE";

    Socket mSocket;
    Emitter.Listener onNewImage;

    {
        try {
            mSocket = IO.socket("http://192.168.2.139:3000");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        onNewImage = new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                handleNewImage(args[0]);
            }
        };
    }



    Button btnChupHinh, btnChonHinh, btnGui;
    ImageView imgShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSocket();
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendImage();
            }
        });
    }

    private void sendImage() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),android.R.drawable.ic_input_add);
        byte[] bytes = getByteArrayFromBitmap(bitmap);
        mSocket.emit(CLIENT_SEND_IMAGE, bytes);

}

    private void addControls() {
        btnChonHinh = (Button) findViewById(R.id.btnChonHinh);
        btnChupHinh = (Button) findViewById(R.id.btnChupHinh);
        btnGui = (Button) findViewById(R.id.btnGui);
    }

    private void initSocket() {
        mSocket.connect();
        mSocket.on(SERVER_SEND_IMAGE, onNewImage);
    }

    private void handleNewImage(final Object arg) {
    }

    public byte[] getByteArrayFromBitmap(Bitmap bm){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

}
io.sockets.on('connection', function (socket){
    console.log("NOTICE: NEW USER CONNECTED");

    socket.on('CLIENT_SEND_IMAGE', function(data){
        console.log(data);
        fs.writeFile("test.png", data);
    });

});
*/

/*
    Các bước thực hiện:
    B1: Cấu hình server nhận kết nối.
    B2: Cấu hình android và test kết nối với server.

    B3: Thiết kế giao diện, khai báo Listener. Nhớ nói để chút nữa khi nhận
    ảnh về để set lên ImageView

    B4: Viết hàm sendImage, copy hàm đổi Bitmap thành ByteArray từ snippet, Code ở server nhận hình

    socket.on('CLIENT_SEND_IMAGE', function(data){
        console.log(data);
        fs.writeFile("test.png", data);
    });
*/