package com.emoor.glidee.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

import com.emoor.glidee.Glide;
import com.emoor.glidee.load.model.GenericLoaderFactory;
import com.emoor.glidee.load.model.ModelLoader;
import com.emoor.glidee.load.model.ModelLoaderFactory;
import com.emoor.glidee.load.model.ResourceLoader;

/**
 * A {@link ModelLoader} For translating android resource id models into {@link ParcelFileDescriptor} data.
 */
public class FileDescriptorResourceLoader extends ResourceLoader<ParcelFileDescriptor>
        implements FileDescriptorModelLoader<Integer> {

    /**
     * The default factory for {@link com.emoor.glidee.load.model.file_descriptor.FileDescriptorResourceLoader}s.
     */
    public static class Factory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {

        @Override
        public ModelLoader<Integer, ParcelFileDescriptor> build(Context context, GenericLoaderFactory factories) {
            return new FileDescriptorResourceLoader(context, factories.buildModelLoader(Uri.class,
                    ParcelFileDescriptor.class));
        }

        @Override
        public void teardown() {
            // Do nothing.
        }
    }

    public FileDescriptorResourceLoader(Context context) {
        this(context, Glide.buildFileDescriptorModelLoader(Uri.class, context));
    }

    public FileDescriptorResourceLoader(Context context, ModelLoader<Uri, ParcelFileDescriptor> uriLoader) {
        super(context, uriLoader);
    }
}
