package io.awallet.crypto.alphawallet.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import io.awallet.crypto.alphawallet.interact.FetchTokensInteract;
import io.awallet.crypto.alphawallet.interact.FindDefaultWalletInteract;
import io.awallet.crypto.alphawallet.router.MarketBuyRouter;
import io.awallet.crypto.alphawallet.service.MarketQueueService;

/**
 * Created by James on 20/02/2018.
 */

public class BrowseMarketViewModelFactory implements ViewModelProvider.Factory
{
    private final MarketQueueService marketQueueService;
    private final MarketBuyRouter marketBuyRouter;
    private final FetchTokensInteract fetchTokensInteract;
    private final FindDefaultWalletInteract findDefaultWalletInteract;

    public BrowseMarketViewModelFactory(
            MarketQueueService marketQueueService,
            MarketBuyRouter marketBuyRouter,
            FetchTokensInteract fetchTokensInteract,
            FindDefaultWalletInteract findDefaultWalletInteract) {
        this.marketQueueService = marketQueueService;
        this.marketBuyRouter = marketBuyRouter;
        this.fetchTokensInteract = fetchTokensInteract;
        this.findDefaultWalletInteract = findDefaultWalletInteract;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new BrowseMarketViewModel(marketQueueService, marketBuyRouter, fetchTokensInteract, findDefaultWalletInteract);
    }
}