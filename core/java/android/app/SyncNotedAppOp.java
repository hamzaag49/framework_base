/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.app;

import android.annotation.IntRange;
import android.annotation.NonNull;
import android.annotation.Nullable;
import android.os.Parcelable;

import com.android.internal.annotations.Immutable;
import com.android.internal.util.DataClass;

/**
 * Description of an app-op that was noted for the current process.
 *
 * <p>This is either delivered after a
 * {@link AppOpsManager.OnOpNotedCallback#onNoted(SyncNotedAppOp) two way binder call} or
 * when the app
 * {@link AppOpsManager.OnOpNotedCallback#onSelfNoted(SyncNotedAppOp) notes an app-op for
 * itself}.
 */
@Immutable
/*@DataClass(
        genEqualsHashCode = true,
        genConstructor = false
)
@DataClass.Suppress("getOpCode")*/
public final class SyncNotedAppOp implements Parcelable {

    /** op code of synchronous appop noted */
    private final @IntRange(from = 0L, to = AppOpsManager._NUM_OP - 1) int mOpCode;
    /** attributionTag of synchronous appop noted */
    private final @Nullable String mAttributionTag;

    /**
     * Creates a new SyncNotedAppOp.
     *
     * @param opCode
     *   op code of synchronous appop noted
     * @param attributionTag
     *   attributionTag of synchronous appop noted
     */
    public SyncNotedAppOp(@IntRange(from = 0L) int opCode, @Nullable String attributionTag) {
        this.mOpCode = opCode;
        com.android.internal.util.AnnotationValidations.validate(
                IntRange.class, null, mOpCode,
                "from", 0,
                "to", AppOpsManager._NUM_OP - 1);
        this.mAttributionTag = attributionTag;
    }

    /**
     * @return The op that was noted.
     */
    public @NonNull String getOp() {
        return AppOpsManager.opToPublicName(mOpCode);
    }

    // Code below generated by codegen v1.0.14.
    //
    // DO NOT MODIFY!
    // CHECKSTYLE:OFF Generated code
    //
    // To regenerate run:
    // $ codegen $ANDROID_BUILD_TOP/frameworks/base/core/java/android/app/SyncNotedAppOp.java
    //
    // To exclude the generated code from IntelliJ auto-formatting enable (one-time):
    //   Settings > Editor > Code Style > Formatter Control
    //@formatter:off


    /**
     * attributionTag of synchronous appop noted
     */
    @DataClass.Generated.Member
    public @Nullable String getAttributionTag() {
        return mAttributionTag;
    }

    @Override
    @DataClass.Generated.Member
    public boolean equals(@Nullable Object o) {
        // You can override field equality logic by defining either of the methods like:
        // boolean fieldNameEquals(SyncNotedAppOp other) { ... }
        // boolean fieldNameEquals(FieldType otherValue) { ... }

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        @SuppressWarnings("unchecked")
        SyncNotedAppOp that = (SyncNotedAppOp) o;
        //noinspection PointlessBooleanExpression
        return true
                && mOpCode == that.mOpCode
                && java.util.Objects.equals(mAttributionTag, that.mAttributionTag);
    }

    @Override
    @DataClass.Generated.Member
    public int hashCode() {
        // You can override field hashCode logic by defining methods like:
        // int fieldNameHashCode() { ... }

        int _hash = 1;
        _hash = 31 * _hash + mOpCode;
        _hash = 31 * _hash + java.util.Objects.hashCode(mAttributionTag);
        return _hash;
    }

    @Override
    @DataClass.Generated.Member
    public void writeToParcel(@NonNull android.os.Parcel dest, int flags) {
        // You can override field parcelling by defining methods like:
        // void parcelFieldName(Parcel dest, int flags) { ... }

        byte flg = 0;
        if (mAttributionTag != null) flg |= 0x2;
        dest.writeByte(flg);
        dest.writeInt(mOpCode);
        if (mAttributionTag != null) dest.writeString(mAttributionTag);
    }

    @Override
    @DataClass.Generated.Member
    public int describeContents() { return 0; }

    /** @hide */
    @SuppressWarnings({"unchecked", "RedundantCast"})
    @DataClass.Generated.Member
    /* package-private */ SyncNotedAppOp(@NonNull android.os.Parcel in) {
        // You can override field unparcelling by defining methods like:
        // static FieldType unparcelFieldName(Parcel in) { ... }

        byte flg = in.readByte();
        int opCode = in.readInt();
        String attributionTag = (flg & 0x2) == 0 ? null : in.readString();

        this.mOpCode = opCode;
        com.android.internal.util.AnnotationValidations.validate(
                IntRange.class, null, mOpCode,
                "from", 0,
                "to", AppOpsManager._NUM_OP - 1);
        this.mAttributionTag = attributionTag;

        // onConstructed(); // You can define this method to get a callback
    }

    @DataClass.Generated.Member
    public static final @NonNull Parcelable.Creator<SyncNotedAppOp> CREATOR
            = new Parcelable.Creator<SyncNotedAppOp>() {
        @Override
        public SyncNotedAppOp[] newArray(int size) {
            return new SyncNotedAppOp[size];
        }

        @Override
        public SyncNotedAppOp createFromParcel(@NonNull android.os.Parcel in) {
            return new SyncNotedAppOp(in);
        }
    };

    /*@DataClass.Generated(
            time = 1579188889960L,
            codegenVersion = "1.0.14",
            sourceFile = "frameworks/base/core/java/android/app/SyncNotedAppOp.java",
            inputSignatures = "private final @android.annotation.IntRange(from=0L, to=AppOpsManager._NUM_OP - 1) int mOpCode\nprivate final @android.annotation.Nullable java.lang.String mAttributionTag\npublic @android.annotation.NonNull java.lang.String getOp()\npublic @android.annotation.SystemApi int getOpCode()\nclass SyncNotedAppOp extends java.lang.Object implements [android.os.Parcelable]\n@com.android.internal.util.DataClass(genEqualsHashCode=true, genConstructor=false)")*/
    @Deprecated
    private void __metadata() {}


    //@formatter:on
    // End of generated code

}