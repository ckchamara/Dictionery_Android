package com.example.dictionery.Adapters;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionery.Models.Phonetics;
import com.example.dictionery.R;
import com.example.dictionery.ViewHolders.PhoneticViewHolder;

import java.util.List;

public class PhoneticsAdapter extends RecyclerView.Adapter<PhoneticViewHolder> {
    private Context context;
    private List<Phonetics> phoneticsList;

    public PhoneticsAdapter(Context context, List<Phonetics> phoneticsList) {
        this.context = context;
        this.phoneticsList = phoneticsList;
    }

    @NonNull
    @Override
    public PhoneticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhoneticViewHolder(LayoutInflater.from(context).inflate(R.layout.phonetic_list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticViewHolder holder, int position) {
        holder.textView_phonetic.setText(phoneticsList.get(position).getText());
        holder.imageButton_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer player = new MediaPlayer();
                try {
                    player.setAudioAttributes(new AudioAttributes.Builder()
                            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                            .build());
                    player.setDataSource(phoneticsList.get(position).getAudio());
//                    player.setDataSource("https://api.dictionaryapi.dev/media/pronunciations/en/hello-au.mp3");
                    player.prepare();
                    player.start();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, "Could't Play Audio..!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return phoneticsList.size();
    }
}
