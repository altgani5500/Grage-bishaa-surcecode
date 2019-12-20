package com.example.user.grage_bisha;

import java.io.File;
import java.util.ArrayList;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

@SuppressWarnings("unused")
public class UploadActivity extends Activity {
	private int count;
	private Bitmap[] thumbnails;
	private boolean[] thumbnailsselection;
	private String[] arrPath;
	private ImageAdapter imageAdapter;
	private static final int PICK_FROM_CAMERA = 1;
	ArrayList<String> IPath = new ArrayList<String>();
	public static Uri uri;

	/** Called when the activity is first created. */
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_upload);

		final String[] columns = { MediaStore.Images.Media.DATA,
				MediaStore.Images.Media._ID };
		final String orderBy = MediaStore.Images.Media._ID;
		Cursor imagecursor = managedQuery(
				MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null,
				null, orderBy);
		int image_column_index = imagecursor
				.getColumnIndex(MediaStore.Images.Media._ID);
		this.count = imagecursor.getCount();
		this.thumbnails = new Bitmap[this.count];
		this.arrPath = new String[this.count];
		this.thumbnailsselection = new boolean[this.count];
		for (int i = 0; i < this.count; i++) {
			imagecursor.moveToPosition(i);
			int id = imagecursor.getInt(image_column_index);
			int dataColumnIndex = imagecursor
					.getColumnIndex(MediaStore.Images.Media.DATA);
			thumbnails[i] = MediaStore.Images.Thumbnails.getThumbnail(
					getApplicationContext().getContentResolver(), id,
					MediaStore.Images.Thumbnails.MICRO_KIND, null);
			arrPath[i] = imagecursor.getString(dataColumnIndex);
		}
		GridView imagegrid = (GridView) findViewById(R.id.PhoneImageGrid);
		imageAdapter = new ImageAdapter();
		imagegrid.setAdapter(imageAdapter);
		imagecursor.close();

		// final Button cameraBtn = (Button) findViewById(R.id.cameraBtn);
		// cameraBtn.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View arg0) {
		// // TODO Auto-generated method stub
		// Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		//
		// uri = Uri.fromFile(new File(Environment
		// .getExternalStorageDirectory(), "tmp_avatar_"
		// + String.valueOf(System.currentTimeMillis()) + ".jpg"));
		//
		// intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, uri);
		// try {
		// intent.putExtra("return-data", true);
		// startActivityForResult(intent, PICK_FROM_CAMERA);
		// } catch (ActivityNotFoundException e) {
		// e.printStackTrace();
		// }
		// }
		// });

		final Button uploadBtn = (Button) findViewById(R.id.uploadDONE);
		uploadBtn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				final int len = thumbnailsselection.length;
				int cnt = 0;
				String selectImages = "";
				for (int i = 0; i < len; i++) {
					if (thumbnailsselection[i]) {
						cnt++;
						selectImages = arrPath[i];
						IPath.add(selectImages);
					}
				}

				if (cnt == 0) {
					Toast.makeText(getApplicationContext(),
							"Please select at least one image",
							Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(),
							"You've selected Total " + cnt + " image(s).",
							Toast.LENGTH_LONG).show();
					Log.d("SelectedImages", selectImages);

					// Intent intentMessage = new Intent();
					// intentMessage.putExtra("IMAGE", IPath);
					// setResult(Activity.RESULT_OK, intentMessage);
					// finish();

					Intent intentMessage = new Intent(UploadActivity.this,
							MainActivity.class);
					intentMessage.putStringArrayListExtra("IMAGE", IPath);
					startActivity(intentMessage);
				}
			}
		});
	}

	public class ImageAdapter extends BaseAdapter {
		private LayoutInflater mInflater;

		public ImageAdapter() {
			mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		public int getCount() {
			return count;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = mInflater.inflate(R.layout.galleryitem, null);
				holder.imageview = (ImageView) convertView
						.findViewById(R.id.thumbImage);
				holder.checkbox = (CheckBox) convertView
						.findViewById(R.id.itemCheckBox);

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.checkbox.setId(position);
			holder.imageview.setId(position);
			holder.checkbox.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					CheckBox cb = (CheckBox) v;
					int id = cb.getId();
					if (thumbnailsselection[id]) {
						cb.setChecked(false);
						thumbnailsselection[id] = false;
					} else {
						cb.setChecked(true);
						thumbnailsselection[id] = true;
					}
				}
			});

			// holder.imageview.setOnClickListener(new OnClickListener() {
			//
			// public void onClick(View v) {
			// // TODO Auto-generated method stub
			// int id = v.getId();
			// Intent intent = new Intent();
			// intent.setAction(Intent.ACTION_VIEW);
			// intent.setDataAndType(Uri.parse("file://" + arrPath[id]),
			// "image/*");
			// startActivity(intent);
			// }
			// });

			holder.imageview.setImageBitmap(thumbnails[position]);
			holder.checkbox.setChecked(thumbnailsselection[position]);
			holder.id = position;
			return convertView;
		}
	}

	class ViewHolder {
		ImageView imageview;
		CheckBox checkbox;
		int id;
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent i = new Intent(UploadActivity.this, MainActivity.class);
		UploadActivity.this.finish();
		startActivity(i);
		super.onBackPressed();
	}
}