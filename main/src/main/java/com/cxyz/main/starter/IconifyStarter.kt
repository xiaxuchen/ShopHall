package com.cxyz.main.starter

import android.content.Context
import com.cxyz.context.starter.Starter
import com.joanzapata.iconify.Iconify
import com.joanzapata.iconify.fonts.*
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView

class IconifyStarter : Starter {
    override fun load(context: Context) {
        Iconify.with(FontAwesomeModule())
            .with(EntypoModule())
            .with(TypiconsModule())
            .with(MaterialModule())
            .with(MaterialCommunityModule())
            .with(MeteoconsModule())
            .with(WeathericonsModule())
            .with(SimpleLineIconsModule())
            .with(IoniconsModule())

    }
}