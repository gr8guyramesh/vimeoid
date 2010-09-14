package org.vimeoid.activity.user.list;

import java.util.HashMap;
import java.util.Map;

import org.vimeoid.R;

import android.app.ListActivity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;

/**
 * 
 * <dl>
 * <dt>Project:</dt> <dd>vimeoid</dd>
 * <dt>Package:</dt> <dd>org.vimeoid</dd>
 * </dl>
 *
 * <code>Videos</code>
 *
 * <p>Activity that shows a Vimeo Items list (Video, User, Channel, Album ...) to a user
 * that has logged in</p>
 *
 * @author Ulric Wilfred <shaman.sir@gmail.com>
 * @date Sep 3, 2010 11:55:11 PM 
 *
 */

// TODO: for sync use SyncAdapter on API Level 7
public class VideosActivity extends ListActivity {
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.generic_list);
        
        // TODO: show loading bar, support API pages        
        
        // this.registerForContextMenu();
        
        /* setListAdapter(new SimpleAdapter(this, callStubVideosList(),
                R.layout.item_video, 
                new String[] { Video.FieldsKeys.TITLE, 
                               Video.FieldsKeys.AUTHOR, 
                               Video.FieldsKeys.DURATION, 
                               Video.FieldsKeys.TAGS },
                new int[] { R.id.videoItemTitle, R.id.videoItemAuthor,
                            R.id.videoItemDuration, R.id.videoItemTags })); */
        
        /* Button tagsButton = (Button) findViewById(R.id.myLikesButton);
        
        tagsButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                setListAdapter(new SimpleAdapter(Videos.this, callStubTagsList(),
                        R.layout.item_tag, 
                        new String[] { TagInfo.FieldsKeys.NAME, 
                                       TagInfo.FieldsKeys.USAGE_COUNT },
                        new int[] { R.id.tagItemName, R.id.tagItemUsageCount }));
                onContentChanged();  
            }
            
        }); */
        
    }
        
    /* private List<Video> getVideosFor(String user) {
        final URI vimeoApiUri = VimeoApi.resolveUriForSimpleApi(
                Uri.withAppendedPath(VimeoProvider.BASE_URI, "/user/" + user + "/videos"));
        try {
            JSONArray videosArr = JsonOverHttp.use().askForArray(vimeoApiUri);
            final List<Video> result = new LinkedList<Video>();
            for (int i = 0; i < videosArr.length(); i++) {
                 JSONObject videoObj = (JSONObject)videosArr.get(i);
                 Video video = new Video();
                 video.id = videoObj.getInt("id");
                 video.title = videoObj.getString("title");
                 video.description = videoObj.getString("description");
                 video.duration = videoObj.getInt("duration");
                 video.tags = videoObj.getString("tags").split(",");
                 video.uploaderName = videoObj.getString("user_name");
                 result.add(video);
            }
            return result;
        } catch (ClientProtocolException cpe) {
            Dialogs.makeExceptionToast(this, "Client protocol exception", cpe);
            cpe.printStackTrace();
        } catch (JSONException jsone) {
            Dialogs.makeExceptionToast(this, "JSON parsing exception", jsone);
            jsone.printStackTrace();
        } catch (IOException ioe) {
            Dialogs.makeExceptionToast(this, "Connection/IO exception", ioe);
            ioe.printStackTrace();
        }
        return Collections.emptyList();
    } */
    
    protected static Map<String, Object> adaptContent(ContentValues values) {
        if (values == null) return new HashMap<String, Object>();
        
        final Map<String, Object> result = new HashMap<String, Object>();        

        for (final Map.Entry<String, Object> entry: values.valueSet()) {
            result.put(entry.getKey(), entry.getValue());
        }
        
        return result;        
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onPrepareOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        
        /* MenuInflater inflater = getMenuInflater(); //from activity
        inflater.inflate(R.menu.main_options_menu, menu); 
        
        return true; */
        
        return super.onPrepareOptionsMenu(menu);
    }
    
    /* (non-Javadoc)
     * @see android.app.Activity#onCreateContextMenu(android.view.ContextMenu, android.view.View, android.view.ContextMenu.ContextMenuInfo)
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        
        /* MenuInflater inflater = getMenuInflater(); //from activity
        inflater.inflate(R.menu.video_context_menu, menu); 
        
        return true; */
        
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    
    /* (non-Javadoc)
     * @see android.app.Activity#onContextItemSelected(android.view.MenuItem)
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        return super.onContextItemSelected(item);
    }
    
    /* (non-Javadoc)
     * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        return super.onOptionsItemSelected(item);
    }
}