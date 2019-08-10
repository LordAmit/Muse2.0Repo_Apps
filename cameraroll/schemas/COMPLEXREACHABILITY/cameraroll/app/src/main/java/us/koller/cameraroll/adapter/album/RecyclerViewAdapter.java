package us.koller.cameraroll.adapter.album;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelflisar.dragselectrecyclerview.DragSelectTouchListener;

import us.koller.cameraroll.R;
import us.koller.cameraroll.adapter.SelectorModeManager;
import us.koller.cameraroll.adapter.album.viewHolder.AlbumItemHolder;
import us.koller.cameraroll.adapter.album.viewHolder.GifViewHolder;
import us.koller.cameraroll.adapter.album.viewHolder.PhotoViewHolder;
import us.koller.cameraroll.adapter.album.viewHolder.RAWImageHolder;
import us.koller.cameraroll.adapter.album.viewHolder.VideoViewHolder;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.Gif;
import us.koller.cameraroll.data.models.Photo;
import us.koller.cameraroll.data.models.RAWImage;
import us.koller.cameraroll.data.models.Video;
import us.koller.cameraroll.ui.ItemActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    @SuppressWarnings("FieldCanBeLocal")
    private final int VIEW_TYPE_PHOTO = 1;
    private final int VIEW_TYPE_GIF = 2;
    private final int VIEW_TYPE_VIDEO = 3;
    private final int VIEW_TYPE_RAW = 4;

    private Album album;

    private boolean pick_photos;

    private SelectorModeManager manager;

    private DragSelectTouchListener dragSelectTouchListener;

    public RecyclerViewAdapter(SelectorModeManager.Callback callback, final RecyclerView recyclerView,
                               final Album album, boolean pick_photos) {
        String dataLeAk667 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath667;try {throw new Exception(dataLeAk667);} catch (Exception leakErRor667) {dataLeAkPath667 = leakErRor667.getMessage();}
								android.util.Log.d("leak-667", dataLeAkPath667);
		this.album = album;
        this.pick_photos = pick_photos;

        manager = new SelectorModeManager();
        manager.addCallback(callback);

        if (pick_photos) {
            String dataLeAk668 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay668 = new String[] {"n/a", dataLeAk668};
			String dataLeAkPath668 = leakArRay668[leakArRay668.length - 1];
			android.util.Log.d("leak-668", dataLeAkPath668);
			setSelectorMode(true);
            if (callback != null) {
                String dataLeAk669 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP669 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP669.put("test", new java.util.HashMap<String, String>());
				leakMaP669.get("test").put("test", dataLeAk669);
				String dataLeAkPath669 = leakMaP669.get("test").get("test");
				android.util.Log.d("leak-669", dataLeAkPath669);
				callback.onSelectorModeEnter();
            }
        }

        //disable default change animation
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        if (callback != null && dragSelectEnabled()) {
            String dataLeAk670 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer670 = new StringBuffer();for (char chAr670 : dataLeAk670.toCharArray()) {leakBuFFer670.append(chAr670);}String dataLeAkPath670 = leakBuFFer670.toString();
			android.util.Log.d("leak-670", dataLeAkPath670);
			dragSelectTouchListener = new DragSelectTouchListener()
                    .withSelectListener(new DragSelectTouchListener.OnDragSelectListener() {
                        @Override
                        public void onSelectChange(int start, int end, boolean isSelected) {
                            String dataLeAk671 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath671;try {throw new Exception(dataLeAk671);} catch (Exception leakErRor671) {dataLeAkPath671 = leakErRor671.getMessage();}
							android.util.Log.d("leak-671", dataLeAkPath671);
							for (int i = start; i <= end; i++) {
                                String dataLeAk672 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay672 = new String[] {"n/a", dataLeAk672};
								String dataLeAkPath672 = leakArRay672[leakArRay672.length - 1];
								android.util.Log.d("leak-672", dataLeAkPath672);
								manager.onItemSelect(album.getAlbumItems().get(i).getPath());
                                //update ViewHolder
                                notifyItemChanged(i);
                            }
                        }
                    });
            recyclerView.addOnItemTouchListener(dragSelectTouchListener);
        }
    }

    public void setSelectorModeManager(SelectorModeManager manager) {
        String dataLeAk673 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP673 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP673.put("test", new java.util.HashMap<String, String>());
		leakMaP673.get("test").put("test", dataLeAk673);
		String dataLeAkPath673 = leakMaP673.get("test").get("test");
		android.util.Log.d("leak-673", dataLeAkPath673);
		this.manager = manager;
    }

    @Override
    public int getItemViewType(int position) {
        String dataLeAk674 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer674 = new StringBuffer();for (char chAr674 : dataLeAk674.toCharArray()) {leakBuFFer674.append(chAr674);}String dataLeAkPath674 = leakBuFFer674.toString();
		android.util.Log.d("leak-674", dataLeAkPath674);
		AlbumItem albumItem = album.getAlbumItems().get(position);
        if (albumItem instanceof RAWImage) {
            String dataLeAk675 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath675;try {throw new Exception(dataLeAk675);} catch (Exception leakErRor675) {dataLeAkPath675 = leakErRor675.getMessage();}
			android.util.Log.d("leak-675", dataLeAkPath675);
			return VIEW_TYPE_RAW;
        } else if (albumItem instanceof Gif) {
            String dataLeAk676 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay676 = new String[] {"n/a", dataLeAk676};
			String dataLeAkPath676 = leakArRay676[leakArRay676.length - 1];
			android.util.Log.d("leak-676", dataLeAkPath676);
			return VIEW_TYPE_GIF;
        } else if (albumItem instanceof Photo) {
            String dataLeAk677 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP677 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP677.put("test", new java.util.HashMap<String, String>());
			leakMaP677.get("test").put("test", dataLeAk677);
			String dataLeAkPath677 = leakMaP677.get("test").get("test");
			android.util.Log.d("leak-677", dataLeAkPath677);
			return VIEW_TYPE_PHOTO;
        } else if (albumItem instanceof Video) {
            String dataLeAk678 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer678 = new StringBuffer();for (char chAr678 : dataLeAk678.toCharArray()) {leakBuFFer678.append(chAr678);}String dataLeAkPath678 = leakBuFFer678.toString();
			android.util.Log.d("leak-678", dataLeAkPath678);
			return VIEW_TYPE_VIDEO;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        String dataLeAk679 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath679;try {throw new Exception(dataLeAk679);} catch (Exception leakErRor679) {dataLeAkPath679 = leakErRor679.getMessage();}
		android.util.Log.d("leak-679", dataLeAkPath679);
		View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.albumitem_cover, parent, false);
        switch (viewType) {
            case VIEW_TYPE_RAW:
                return new RAWImageHolder(v);
            case VIEW_TYPE_GIF:
                return new GifViewHolder(v);
            case VIEW_TYPE_VIDEO:
                return new VideoViewHolder(v);
            case VIEW_TYPE_PHOTO:
                return new PhotoViewHolder(v);
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        String dataLeAk680 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay680 = new String[] {"n/a", dataLeAk680};
		String dataLeAkPath680 = leakArRay680[leakArRay680.length - 1];
		android.util.Log.d("leak-680", dataLeAkPath680);
		final AlbumItem albumItem = album.getAlbumItems().get(position);

        if (!albumItem.equals(((AlbumItemHolder) holder).getAlbumItem())) {
            String dataLeAk681 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP681 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP681.put("test", new java.util.HashMap<String, String>());
			leakMaP681.get("test").put("test", dataLeAk681);
			String dataLeAkPath681 = leakMaP681.get("test").get("test");
			android.util.Log.d("leak-681", dataLeAkPath681);
			((AlbumItemHolder) holder).setAlbumItem(albumItem);
        }

        boolean selected = manager.isItemSelected(albumItem.getPath());

        ((AlbumItemHolder) holder).setSelected(selected);

        holder.itemView.setTag(albumItem.getPath());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataLeAk682 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer682 = new StringBuffer();for (char chAr682 : dataLeAk682.toCharArray()) {leakBuFFer682.append(chAr682);}String dataLeAkPath682 = leakBuFFer682.toString();
				android.util.Log.d("leak-682", dataLeAkPath682);
				if (getSelectorMode()) {
                    String dataLeAk683 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath683;try {throw new Exception(dataLeAk683);} catch (Exception leakErRor683) {dataLeAkPath683 = leakErRor683.getMessage();}
					android.util.Log.d("leak-683", dataLeAkPath683);
					onItemSelected((AlbumItemHolder) holder);
                } else {
                    String dataLeAk684 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay684 = new String[] {"n/a", dataLeAk684};
					String dataLeAkPath684 = leakArRay684[leakArRay684.length - 1];
					android.util.Log.d("leak-684", dataLeAkPath684);
					Context context = holder.itemView.getContext();
                    Intent intent = new Intent(context, ItemActivity.class);
                    intent.putExtra(ItemActivity.ALBUM_ITEM, albumItem);
                    intent.putExtra(ItemActivity.ALBUM_PATH, album.getPath());
                    intent.putExtra(ItemActivity.ITEM_POSITION, album.getAlbumItems().indexOf(albumItem));

                    ActivityOptionsCompat options =
                            ActivityOptionsCompat.makeSceneTransitionAnimation(
                                    (Activity) context, holder.itemView.findViewById(R.id.image),
                                    albumItem.getPath());
                    ActivityCompat.startActivityForResult((Activity) context, intent,
                            ItemActivity.VIEW_IMAGE, options.toBundle());
                }
            }
        });

        if (getSelectorManager().callbacksAttached()) {
            String dataLeAk685 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP685 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP685.put("test", new java.util.HashMap<String, String>());
			leakMaP685.get("test").put("test", dataLeAk685);
			String dataLeAkPath685 = leakMaP685.get("test").get("test");
			android.util.Log.d("leak-685", dataLeAkPath685);
			holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    String dataLeAk686 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer686 = new StringBuffer();for (char chAr686 : dataLeAk686.toCharArray()) {leakBuFFer686.append(chAr686);}String dataLeAkPath686 = leakBuFFer686.toString();
					android.util.Log.d("leak-686", dataLeAkPath686);
					if (!getSelectorMode()) {
                        String dataLeAk687 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath687;try {throw new Exception(dataLeAk687);} catch (Exception leakErRor687) {dataLeAkPath687 = leakErRor687.getMessage();}
						android.util.Log.d("leak-687", dataLeAkPath687);
						setSelectorMode(true);
                        clearSelectedItemsList();
                    }

                    onItemSelected((AlbumItemHolder) holder);

                    if (dragSelectEnabled()) {
                        String dataLeAk688 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay688 = new String[] {"n/a", dataLeAk688};
						String dataLeAkPath688 = leakArRay688[leakArRay688.length - 1];
						android.util.Log.d("leak-688", dataLeAkPath688);
						//notify DragSelectTouchListener
                        boolean selected = manager.isItemSelected(albumItem.getPath());
                        if (selected) {
                            String dataLeAk689 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP689 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP689.put("test", new java.util.HashMap<String, String>());
							leakMaP689.get("test").put("test", dataLeAk689);
							String dataLeAkPath689 = leakMaP689.get("test").get("test");
							android.util.Log.d("leak-689", dataLeAkPath689);
							int position = getAlbum().getAlbumItems().indexOf(albumItem);
                            dragSelectTouchListener.startDragSelection(position);
                        }
                    }
                    return true;
                }
            });
        }
    }

    public boolean isSelectorModeActive() {
        String dataLeAk690 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer690 = new StringBuffer();for (char chAr690 : dataLeAk690.toCharArray()) {leakBuFFer690.append(chAr690);}String dataLeAkPath690 = leakBuFFer690.toString();
		android.util.Log.d("leak-690", dataLeAkPath690);
		return getSelectorMode() && !pick_photos;
    }

    public void restoreSelectedItems() {
        String dataLeAk691 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath691;try {throw new Exception(dataLeAk691);} catch (Exception leakErRor691) {dataLeAkPath691 = leakErRor691.getMessage();}
		android.util.Log.d("leak-691", dataLeAkPath691);
		//notify AlbumActivity
        getSelectorManager().onSelectorModeEnter();

        for (int i = 0; i < this.album.getAlbumItems().size(); i++) {
            String dataLeAk692 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay692 = new String[] {"n/a", dataLeAk692};
			String dataLeAkPath692 = leakArRay692[leakArRay692.length - 1];
			android.util.Log.d("leak-692", dataLeAkPath692);
			if (manager.isItemSelected(album.getAlbumItems().get(i).getPath())) {
                String dataLeAk693 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP693 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP693.put("test", new java.util.HashMap<String, String>());
				leakMaP693.get("test").put("test", dataLeAk693);
				String dataLeAkPath693 = leakMaP693.get("test").get("test");
				android.util.Log.d("leak-693", dataLeAkPath693);
				notifyItemChanged(i);
            }
        }

        getSelectorManager().onItemSelected(manager.getSelectedItemCount());
    }

    private void checkForNoSelectedItems() {
        String dataLeAk694 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer694 = new StringBuffer();for (char chAr694 : dataLeAk694.toCharArray()) {leakBuFFer694.append(chAr694);}String dataLeAkPath694 = leakBuFFer694.toString();
		android.util.Log.d("leak-694", dataLeAkPath694);
		if (getSelectedItemCount() == 0 && !pick_photos) {
            String dataLeAk695 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath695;try {throw new Exception(dataLeAk695);} catch (Exception leakErRor695) {dataLeAkPath695 = leakErRor695.getMessage();}
			android.util.Log.d("leak-695", dataLeAkPath695);
			cancelSelectorMode(null);
        }
    }

    private int getSelectedItemCount() {
        String dataLeAk696 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay696 = new String[] {"n/a", dataLeAk696};
		String dataLeAkPath696 = leakArRay696[leakArRay696.length - 1];
		android.util.Log.d("leak-696", dataLeAkPath696);
		return manager.getSelectedItemCount();
    }

    private void onItemSelected(AlbumItemHolder holder) {
        String dataLeAk697 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP697 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP697.put("test", new java.util.HashMap<String, String>());
		leakMaP697.get("test").put("test", dataLeAk697);
		String dataLeAkPath697 = leakMaP697.get("test").get("test");
		android.util.Log.d("leak-697", dataLeAkPath697);
		boolean selected = manager.onItemSelect(holder.albumItem.getPath());
        holder.setSelected(selected);
        checkForNoSelectedItems();
    }

    public String[] cancelSelectorMode(Activity context) {
        String dataLeAk698 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer698 = new StringBuffer();for (char chAr698 : dataLeAk698.toCharArray()) {leakBuFFer698.append(chAr698);}String dataLeAkPath698 = leakBuFFer698.toString();
		android.util.Log.d("leak-698", dataLeAkPath698);
		setSelectorMode(false);
        //update ui
        for (int i = 0; i < this.album.getAlbumItems().size(); i++) {
            String dataLeAk699 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath699;try {throw new Exception(dataLeAk699);} catch (Exception leakErRor699) {dataLeAkPath699 = leakErRor699.getMessage();}
			android.util.Log.d("leak-699", dataLeAkPath699);
			if (manager.isItemSelected(album.getAlbumItems().get(i).getPath())) {
                String dataLeAk700 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay700 = new String[] {"n/a", dataLeAk700};
				String dataLeAkPath700 = leakArRay700[leakArRay700.length - 1];
				android.util.Log.d("leak-700", dataLeAkPath700);
				notifyItemChanged(i);
            }
        }
        //generate paths array
        String[] paths;
        if (context != null) {
            String dataLeAk701 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP701 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP701.put("test", new java.util.HashMap<String, String>());
			leakMaP701.get("test").put("test", dataLeAk701);
			String dataLeAkPath701 = leakMaP701.get("test").get("test");
			android.util.Log.d("leak-701", dataLeAkPath701);
			paths = manager.createStringArray(context);
        } else {
            String dataLeAk702 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer702 = new StringBuffer();for (char chAr702 : dataLeAk702.toCharArray()) {leakBuFFer702.append(chAr702);}String dataLeAkPath702 = leakBuFFer702.toString();
			android.util.Log.d("leak-702", dataLeAkPath702);
			paths = null;
        }
        //clear manager list
        clearSelectedItemsList();
        return paths;
    }

    public boolean onBackPressed() {
        String dataLeAk703 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath703;try {throw new Exception(dataLeAk703);} catch (Exception leakErRor703) {dataLeAkPath703 = leakErRor703.getMessage();}
		android.util.Log.d("leak-703", dataLeAkPath703);
		if (getSelectorMode() && !pick_photos) {
            String dataLeAk704 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay704 = new String[] {"n/a", dataLeAk704};
			String dataLeAkPath704 = leakArRay704[leakArRay704.length - 1];
			android.util.Log.d("leak-704", dataLeAkPath704);
			cancelSelectorMode(null);
            return true;
        }
        return false;
    }

    private boolean getSelectorMode() {
        String dataLeAk705 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP705 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP705.put("test", new java.util.HashMap<String, String>());
		leakMaP705.get("test").put("test", dataLeAk705);
		String dataLeAkPath705 = leakMaP705.get("test").get("test");
		android.util.Log.d("leak-705", dataLeAkPath705);
		return manager.isSelectorModeActive();
    }

    private void setSelectorMode(boolean activate) {
        String dataLeAk706 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer706 = new StringBuffer();for (char chAr706 : dataLeAk706.toCharArray()) {leakBuFFer706.append(chAr706);}String dataLeAkPath706 = leakBuFFer706.toString();
		android.util.Log.d("leak-706", dataLeAkPath706);
		manager.setSelectorMode(activate);
    }

    public boolean dragSelectEnabled() {
        String dataLeAk707 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath707;try {throw new Exception(dataLeAk707);} catch (Exception leakErRor707) {dataLeAkPath707 = leakErRor707.getMessage();}
		android.util.Log.d("leak-707", dataLeAkPath707);
		return true;
    }

    private void clearSelectedItemsList() {
        String dataLeAk708 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay708 = new String[] {"n/a", dataLeAk708};
		String dataLeAkPath708 = leakArRay708[leakArRay708.length - 1];
		android.util.Log.d("leak-708", dataLeAkPath708);
		manager.clearList();
    }

    @Override
    public int getItemCount() {
        String dataLeAk709 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP709 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP709.put("test", new java.util.HashMap<String, String>());
		leakMaP709.get("test").put("test", dataLeAk709);
		String dataLeAkPath709 = leakMaP709.get("test").get("test");
		android.util.Log.d("leak-709", dataLeAkPath709);
		return getAlbum().getAlbumItems().size();
    }

    public Album getAlbum() {
        String dataLeAk710 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer710 = new StringBuffer();for (char chAr710 : dataLeAk710.toCharArray()) {leakBuFFer710.append(chAr710);}String dataLeAkPath710 = leakBuFFer710.toString();
		android.util.Log.d("leak-710", dataLeAkPath710);
		return album;
    }

    public void setAlbum(Album album) {
        String dataLeAk711 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath711;try {throw new Exception(dataLeAk711);} catch (Exception leakErRor711) {dataLeAkPath711 = leakErRor711.getMessage();}
		android.util.Log.d("leak-711", dataLeAkPath711);
		this.album = album;
    }

    public SelectorModeManager getSelectorManager() {
        String dataLeAk712 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay712 = new String[] {"n/a", dataLeAk712};
		String dataLeAkPath712 = leakArRay712[leakArRay712.length - 1];
		android.util.Log.d("leak-712", dataLeAkPath712);
		return manager;
    }

    public void saveInstanceState(Bundle state) {
        String dataLeAk713 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP713 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP713.put("test", new java.util.HashMap<String, String>());
		leakMaP713.get("test").put("test", dataLeAk713);
		String dataLeAkPath713 = leakMaP713.get("test").get("test");
		android.util.Log.d("leak-713", dataLeAkPath713);
		manager.saveInstanceState(state);
    }
}
