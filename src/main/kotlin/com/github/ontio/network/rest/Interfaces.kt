/*
 * Copyright (C) 2018 The ontology Authors
 * This file is part of The ontology library.
 *
 *  The ontology is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  The ontology is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with The ontology.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.github.ontio.network.rest

import com.github.ontio.common.ErrorCode
import com.github.ontio.network.exception.RestfulException
import java.util.*

/**
 *
 */
internal class Interfaces(val url: String) {
    fun getNodeCount(): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_node_count, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }
    }

    fun getBlockHeight(): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_block_height, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }
    }

    fun getMemPoolTxCount(): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_mem_pool_tx_count, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getVersion(): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_version, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun sendTransaction(preExec: Boolean, userid: String?, action: String, version: String, data: String): String {
        val params = HashMap<String, String>()
        if (userid != null) {
            params["userid"] = userid
        }
        if (preExec) {
            params["preExec"] = "1"
        }
        val body = HashMap<String, Any>()
        body["Action"] = action
        body["Version"] = version
        body["Data"] = data
        try {
            return http.post(url + UrlConsts.Url_send_transaction, params, body)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr(url), e)

        }

    }

    fun getTransaction(txhash: String, raw: Boolean): String {
        val params = HashMap<String, String>()
        if (raw) {
            params["raw"] = "1"
        }
        try {
            return http.get(url + UrlConsts.Url_get_transaction + txhash, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getBlock(height: Int, raw: String): String {
        val params = HashMap<String, String>()
        params["raw"] = raw
        try {
            return http.get(url + UrlConsts.Url_get_block_by_height + height, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getBlock(hash: String, raw: String): String {
        val params = HashMap<String, String>()
        params["raw"] = raw
        try {
            return http.get(url + UrlConsts.Url_get_block_by_hash + hash, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getContract(hash: String): String {
        val params = HashMap<String, String>()
        params["raw"] = "1"
        try {
            return http.get(url + UrlConsts.Url_get_contract_state + hash, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getContractJson(hash: String): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_contract_state + hash, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getSmartCodeEvent(height: Int): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_smartcodeevent_txs_by_height + height, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getSmartCodeEvent(hash: String): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_smartcodeevent_by_txhash + hash, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getBlockHeightByTxHash(hash: String): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_block_height_by_txhash + hash, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getStorage(codehash: String, key: String): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_storage + codehash + "/" + key, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getMerkleProof(hash: String): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_merkleproof + hash, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getMemPoolTxState(hash: String): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_mem_pool_tx_state + hash, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getBalance(address: String): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_account_balance + address, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getTransactionJson(txhash: String): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_transaction + txhash, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getBlockJson(height: Int): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_block_by_height + height, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getBlockJson(hash: String): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_block_by_hash + hash, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }

    fun getAllowance(asset: String, from: String, to: String): String {
        val params = HashMap<String, String>()
        try {
            return http.get(url + UrlConsts.Url_get_allowance + asset + "/" + from + "/" + to, params)
        } catch (e: Exception) {
            throw RestfulException(ErrorCode.ConnectUrlErr + url, e)
        }

    }
}
