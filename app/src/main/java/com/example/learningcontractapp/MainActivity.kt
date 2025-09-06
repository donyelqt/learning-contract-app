package com.example.learningcontractapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningcontractapp.adapter.GroupMemberAdapter
import com.example.learningcontractapp.data.SampleData
import com.example.learningcontractapp.databinding.ActivityMainBinding

/**
 * Main activity displaying group members and their learning contracts
 * Implements modern Android best practices with ViewBinding and Material Design 3
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: GroupMemberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupToolbar()
        setupRecyclerView()
        loadData()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = getString(R.string.app_name)
            setDisplayShowTitleEnabled(true)
        }
    }

    private fun setupRecyclerView() {
        adapter = GroupMemberAdapter()
        
        binding.recyclerViewMembers.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
            
            // Add smooth scrolling and performance optimizations
            setHasFixedSize(false)
            isNestedScrollingEnabled = false
            
            // Add subtle item animations
            itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator().apply {
                addDuration = 300
                removeDuration = 300
                moveDuration = 300
                changeDuration = 300
            }
        }
    }

    private fun loadData() {
        // Load sample data into the adapter
        val groupMembers = SampleData.getGroupMembers()
        adapter.submitList(groupMembers)
    }

    override fun onDestroy() {
        super.onDestroy()
        // ViewBinding cleanup is automatic, but good practice to nullify references
    }
}
